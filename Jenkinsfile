pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'test_gradle' , url: 'https://github.com/SreypichTO/DevOPs_tp01.git'
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
