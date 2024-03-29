pipeline {
    agent any
    tools {
        gradle 'Gradle8.7'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'test_gradle' , url: 'https://github.com/SreypichTO/DevOPs_tp01.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'gradle build'
            }
        }
        
        stage('Run') {
            steps {
                sh 'gradle bootRun'
            }
        }
    }
}
