pipeline {
    environment {
        registry = "sanir456/scientific-calculator-devopstools-webapp"
        registryCredential = 'docker-cred'
        dockerImage = ''
    }
    agent any
    stages {
        stage('step 1 Git') {
            steps {
                 git url: 'https://github.com/sanir456/ScientificCalculatorDevops.git', branch: 'master',
                 credentialsId: 'git-cred'
            }
        }
        stage('step 2 Build maven') {
            steps {
                sh "mvn -B -DskipTests clean package"
            }
        }

        stage('step 3 Test') {
            steps {
                sh "mvn test"
            }
        }

        stage('step 4 Building docker image') {
            steps{
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }

        stage('step 5 Push docker image to dockerhub') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                    }
                }
            }
        }
        stage('Step 6 Ansible image deploy'){
            steps{
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'ansible-docker-deploy/inventory', playbook: 'ansible-docker-deploy/deploy-image.yml', sudoUser: null
                }
        }

        stage('Step 7 Ansible container creation'){
            steps{
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'ansible-docker-deploy/inventory', playbook: 'ansible-docker-deploy/create-container.yml', sudoUser: null
                }

        }

    }
}