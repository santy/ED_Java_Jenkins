pipeline {
    agent any

    stages {
        stage('Preparar') {
            steps {
                echo 'Preparando el entorno...'
            }
        }

        stage('Compilar') {
            steps {
                echo 'Compilando la aplicación...'
            }
        }

        stage('Test') {
            steps {
                echo 'Ejecutando tests...'
            }
        }

        stage('Desplegar') {
            steps {
                echo 'Desplegando la aplicación...'
            }
        }
    }

    post {
        success {
            echo 'Pipeline ejecutado correctamente ✅'
        }
        failure {
            echo 'Algo falló ❌'
        }
    }
}
