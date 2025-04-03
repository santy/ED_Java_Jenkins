pipeline {
    agent any

    stages {
        stage('Lanzar otro pipeline') {
            steps {
                echo "⏩ Lanzando pipeline hijo: Pipeline-inside"

                build job: 'Pipeline-inside'
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline hijo ejecutado con éxito.'
        }
        failure {
            echo '❌ Error al ejecutar el pipeline hijo.'
        }
    }
}
