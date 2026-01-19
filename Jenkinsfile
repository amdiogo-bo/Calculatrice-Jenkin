pipeline {
    agent any

    tools {
        maven 'Maven' // NOM EXACT configuré dans Jenkins
        JDK 'Java'    // NOM EXACT configuré dans Jenkins
    }

    environment {
        NEXUS_USER = credentials('nexus-credentials') // ID Jenkins Credential
        NEXUS_PASS = credentials('nexus-credentials')
    }

    stages {
        stage('Checkout') {
            steps {
                echo "🔄 Récupération du code depuis GitHub"
                git url: 'https://github.com/amdiogo-bo/Calculatrice-Jenkin.git', branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                echo "⚙️ Compilation et exécution des tests unitaires"
                sh 'mvn clean test'
            }
        }

        stage('Deploy to Nexus') {
            steps {
                echo "🚀 Déploiement sur Nexus SNAPSHOT"
                sh """
                mvn deploy \
                  -Dnexus.username=$NEXUS_USER \
                  -Dnexus.password=$NEXUS_PASS
                """
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo "✅ Build et déploiement réussis !"
        }
        failure {
            echo "❌ Échec du build ou du déploiement."
        }
    }
}
