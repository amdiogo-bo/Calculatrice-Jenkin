pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'java'
    }

    environment {
        SONAR_HOST_URL = 'http://sonarqube:9000'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/amdiogo-bo/Calculatrice-Jenkin.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=calculatrice \
                    -Dsonar.projectName=Calculatrice
                    '''
                }
            }
        }

        stage('Deploy to Nexus') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'nexus-credentials',
                    usernameVariable: 'NEXUS_USER',
                    passwordVariable: 'NEXUS_PWD'
                )]) {
                    sh '''
                    mvn deploy \
                    -DskipTests \
                    -Dnexus.username=$NEXUS_USER \
                    -Dnexus.password=$NEXUS_PWD
                    '''
                }
            }
        }
    }

    post {
        always {
            script {
                if (fileExists('target/surefire-reports')) {
                    junit 'target/surefire-reports/*.xml'
                } else {
                    echo 'Aucun rapport JUnit trouvé'
                }
            }
        }
    }
}
