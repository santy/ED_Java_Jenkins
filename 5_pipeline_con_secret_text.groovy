pipeline {
    agent any

    stages {
        stage('Mostrar Secret Text') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'SECRET_TEXT', variable: 'SECRET_TEXT')]) {
                        echo "🔐 Mostrando secret text..."
                        echo "Texto secreto (echo): ${env.SECRET_TEXT}"
                        sh '''
                            echo "Texto secreto en sh: $SECRET_TEXT"
                        '''
                    }
                }
            }
        }
    }

    post {
        always {
            echo '🧼 Pipeline finalizado.'
        }
    }
}
