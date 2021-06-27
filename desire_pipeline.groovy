def gitUrl = 'https://github.com/alicommit-malp/jenkins_dsl_example'

job('test-job') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        sh "pip install -r $WORKSPACE/python/requirements.txt"
        sh "python $WORKSPACE/python/main.py"
    }
}
