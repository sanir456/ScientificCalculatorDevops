pipeline {
    environment {
        registry = "sanir456/scientific-calculator-devopstools-webapp"
        registryCredential = 'docker-cred'
        dockerImage = ''
    }
    agent any
    stages {
        stage('stage-1 Git pull') {
            steps {
                 git url: 'https://github.com/sanir456/ScientificCalculatorDevops.git', branch: 'master',
                 credentialsId: 'git-cred'
            }
        }
        stage('stage-2 Build maven project') {
            steps {
                sh "mvn -B -DskipTests clean package"
            }
        }

        stage('stage-3 Test build project') {
            steps {
                sh "mvn test"
            }
        }

        stage('stage-4 Build docker image in local machine') {
            steps{
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }

        stage('stage- 5 Push docker image to dockerhub') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                    }
                }
            }
        }
        stage('Stage 6 deploy image from dockerhub to ubuntu18 server'){
            steps{
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'ansible-docker-deploy/inventory', playbook: 'ansible-docker-deploy/deploy-image.yml', sudoUser: null
                }
        }

//         stage('Step 7 Ansible container creation'){
//             steps{
//                 ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'ansible-docker-deploy/inventory', playbook: 'ansible-docker-deploy/create-container.yml', sudoUser: null
//                 }
//
//         }


    }
}