pipeline {
    agent any

    parameters {
        string(name: 'NOMBRE_APP', defaultValue: 'mi-app', description: 'Nombre de la aplicación')
        choice(name: 'ENTORNO', choices: ['desarrollo', 'preproducción', 'producción'], description: 'Entorno de despliegue')
        booleanParam(name: 'EJECUTAR_TESTS', defaultValue: true, description: '¿Ejecutar tests?')
    }

    environment {
        BUILD_INFO = "Build-${BUILD_NUMBER} de ${params.NOMBRE_APP}"
    }

    stages {
        stage('Preparar') {
            steps {
                echo "🛠️ Preparando build para ${params.NOMBRE_APP} en entorno ${params.ENTORNO}"
                echo "Información del build: ${env.BUILD_INFO}"
                sh 'echo "Inicio del proceso"'
            }
        }

        stage('Compilar') {
            steps {
                echo "⚙️ Compilando ${params.NOMBRE_APP}"
                sh '''
                    mkdir -p build
                    echo "Compilación completada para $NOMBRE_APP" > build/info.txt
                '''
            }
        }

        stage('Test') {
            when {
                expression { return params.EJECUTAR_TESTS }
            }
            steps {
                echo "🧪 Ejecutando tests"
                sh 'echo "Tests ejecutados correctamente"'
            }
        }

        stage('Desplegar') {
            steps {
                echo "🚀 Desplegando en entorno: ${params.ENTORNO}"
                sh 'echo "Despliegue completo en entorno $ENTORNO"'
            }
        }
    }

    post {
        success {
            echo "✅ Build finalizado correctamente: ${env.BUILD_INFO}"
        }
        failure {
            echo "❌ Fallo en el build: ${env.BUILD_INFO}"
        }
    }
}
