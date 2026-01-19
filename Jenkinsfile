pipeline {
    agent any

    tools {
            Maven 'Maven' // Nom configuré dans Jenkins
            jdk 'Java'    // Nom configuré dans Jenkins
        }


    environment {
        // On récupère les credentials depuis Jenkins
        NEXUS_CRED = credentials('nexus-creds')
    }


    stages {
        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/amdiogo-bo/Calculatrice-Jenkin.git'

            }
        }

        stage('Build & Test') {
                    steps {
                        sh 'mvn clean test'
                    }
                }

        stage('Deploy to Nexus') {
                steps {
                    // Maven utilise les credentials pour le deploy
                    sh "mvn deploy -Dnexus.username=$NEXUS_CRED_USR -Dnexus.password=$NEXUS_CRED_PSW"
                }
            }
        }

        post {
            always {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
