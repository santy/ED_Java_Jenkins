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
                echo "Build ID: ${env.BUILD_ID}"
            }
        }

        stage('Compilar') {
            steps {
                echo "⚙️ Compilando código para: ${env.PROJECT_NAME}"
            }
        }

        stage('Test') {
            steps {
                echo "🧪 Ejecutando tests en entorno: ${env.DEPLOY_ENV}"
            }
        }

        stage('Desplegar') {
            steps {
                echo "🚀 Desplegando ${env.PROJECT_NAME} al entorno ${env.DEPLOY_ENV}"
            }
        }
    }

    post {
        success {
            echo "✅ Build completado correctamente para ${env.PROJECT_NAME}"
        }
        failure {
            echo "❌ Error en el build número ${env.BUILD_NUMBER}"
        }
    }
}
