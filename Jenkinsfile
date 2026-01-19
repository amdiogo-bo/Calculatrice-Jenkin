pipeline {
    agent any

    tools {
            Maven 'Maven' // Nom configuré dans Jenkins
            jdk 'Java'    // Nom configuré dans Jenkins
        }


    stages {
        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/amdiogo-bo/Calculatrice-Jenkin.git'

            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy Nexus') {
            steps {
                echo "🚀 Déploiement sur Nexus"
                sh 'mvn deploy'
            }
        }

        post {
            always {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
