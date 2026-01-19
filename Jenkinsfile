pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'java'
    }

    environment {
        NEXUS_URL = "http://nexus:8081"
        NEXUS_REPO = "maven-snapshots"
        GROUP_ID = "sn"
        ARTIFACT_ID = "Calculatrice"
    }

    stages {

        stage('Checkout') {
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
                        sh 'mvn clean deploy -DskipTests'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
