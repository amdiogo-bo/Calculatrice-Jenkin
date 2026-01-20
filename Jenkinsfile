pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'java'
    }

    environment {
        // SonarQube
        SONARQUBE_SERVER = 'SonarQube'

        // Nexus
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

        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('Analyse SonarQube') {
            steps {
                withSonarQubeEnv("${SONARQUBE_SERVER}") {
                    sh """
                        mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594:sonar \
                        -Dsonar.projectKey=${ARTIFACT_ID} \
                        -Dsonar.projectName=${ARTIFACT_ID} \
                        -Dsonar.projectVersion=1.0 \
                        -Dsonar.sources=src/main/java \
                        -Dsonar.tests=src/test/java \
                        -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }

        stage('Deploy Nexus') {
            steps {
                echo "🚀 Déploiement sur Nexus"
                sh """
                    mvn clean deploy -DskipTests \
                    -Dnexus.url=${NEXUS_URL} \
                    -Dnexus.repo=${NEXUS_REPO}
                """
            }
        }
    }

    post {
        always {
            junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
        }
    }
}
