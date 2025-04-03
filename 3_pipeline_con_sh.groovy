pipeline {
    agent any

    environment {
        DEPLOY_ENV = 'producción'
        PROJECT_NAME = "${JOB_NAME}"
    }

    stages {
        stage('Preparar') {
            steps {
                echo "🏗️ Preparando entorno para el proyecto: ${env.PROJECT_NAME}"
                echo "Workspace: ${env.WORKSPACE}"
                sh 'echo "Entorno preparado"'
            }
        }

        stage('Compilar') {
            steps {
                echo "⚙️ Compilando código"
                sh '''
                    echo "Iniciando compilación..."
                    mkdir -p build
                    echo "Compilación completada." > build/info.txt
                '''
            }
        }

        stage('Test') {
            steps {
                echo "🧪 Ejecutando tests"
                sh '''
                    echo "Tests en curso..."
                    echo "Tests completados."
                '''
            }
        }

        stage('Desplegar') {
            steps {
                echo "🚀 Desplegando en entorno ${env.DEPLOY_ENV}"
                sh 'echo "Despliegue simulado completado"'
            }
        }
    }

    post {
        success {
            echo "✅ Build completado correctamente"
        }
        failure {
            echo "❌ Error en el build"
        }
    }
}
