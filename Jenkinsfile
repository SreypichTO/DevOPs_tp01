pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from your version control system (e.g., Git)
                git 'your_git_repository_url'
            }
        }
        
        stage('Build') {
            steps {
                // Build the Spring Boot project using Gradle
                sh './gradlew build'
            }
        }
        
        stage('Run') {
            steps {
                // Run the Spring Boot application
                sh './gradlew bootRun'
            }
        }
    }
    
    post {
        success {
            echo 'Spring Boot application ran successfully!'
        }
        
        failure {
            echo 'Failed to run Spring Boot application!'
        }
    }
}
