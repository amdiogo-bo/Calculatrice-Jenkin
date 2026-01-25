pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'java'
    }

    environment {
        SONAR_HOST_URL = 'http://sonarqube:9000'
        SONARQUBE_SERVER = 'SonarQube'
        SONAR_TOKEN = credentials('sonar-token')
        NEXUS_CREDENTIALS = credentials('nexus-credentials')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/amdiogo-bo/Calculatrice-Jenkin.git'
            }
        }

        stage('Compile & Test') {
            steps {
                sh 'mvn clean test'
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

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy to Nexus') {
            steps {
                sh 'mvn deploy'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
