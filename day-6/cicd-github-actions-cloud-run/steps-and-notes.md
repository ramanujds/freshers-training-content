## Create a CloudRun Service
- Go to the [Google Cloud Console](https://console.cloud.google.com/).
- Select your project.
- Navigate to **Cloud Run** in the left sidebar.
- Click on **Create Service**.

### Note: use the demo hello image initially

## Create an Artifact Registry Repository

- Go to the [Google Cloud Console](https://console.cloud.google.com/).
- Select your project.
- Navigate to **Artifact Registry** in the left sidebar.
- Click on **Create Repository**.
- Fill in the repository details:
  - **Name**: Choose a name for your repository.
  - **Format**: Select `Docker`.
  - **Location**: Choose a region or multi-region.
  - **Description**: Optionally, add a description.
  - 

## Create a Github Repository

## For GCP Authentication

### Go to IAM & Admin -> Service Accounts
### Select the existing service account or create a new key
### Download the JSON key file for the service account.

### Go to settings of your GitHub repository
- Click on **Settings** in your GitHub repository.
- Click on **Secrets and variables** in the left sidebar.
- Click on **Actions**.
- Click on **New repository secret**.
- Name the secret `GCP_SA_KEY` and paste the contents of your service account JSON key file into the value field.
- Click **Add secret**.
- Name another secret `GCP_PROJECT_ID` and set its value to your Google Cloud project ID.
- Click **Add secret**.


## Create a Github Action Workflow

- Click **Create** to create the repository.
- Click on the **Actions** tab in your GitHub repository.
- Click on **New workflow**.
- Choose **Set up a workflow yourself** or select a template.
- Edit the workflow file (e.g., `.github/workflows/deploy.yml`) with the following content:

```yaml
name: Deploy to Cloud Run

on:
  push:
    branches:
      - main

jobs:
  deploy:
    runs-on: ubuntu-latest

    env:
      REGION: us-central1
      REPOSITORY: my-docker-repo
      SERVICE_NAME: my-app
      IMAGE_NAME: spring-boot

    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Authenticate with GCP
        uses: google-github-actions/auth@v2
        with:
          credentials_json: ${{ secrets.GCP_SA_KEY }}

      - name: Set up Google Cloud CLI
        uses: google-github-actions/setup-gcloud@v1
        with:
          project_id: ${{ secrets.GCP_PROJECT_ID }}
          install_components: 'beta'

      #      - name: Echo project ID
      #        run: echo "Project ID: ${{ secrets.GCP_PROJECT_ID }}"

      # Task 1: Configure Docker for Artifact Registry
      - name: Configure Docker
        run: |
          gcloud auth configure-docker ${{ env.REGION }}-docker.pkg.dev

      # Task 2: Build and Push Docker image
      - name: Build and Push Docker image
        run: |
          IMAGE_URI="${{ env.REGION }}-docker.pkg.dev/${{ secrets.GCP_PROJECT_ID }}/${{ env.REPOSITORY }}/${{ env.IMAGE_NAME }}"
          docker build -t "$IMAGE_URI" .
          docker push "$IMAGE_URI"
          echo "IMAGE_URI=$IMAGE_URI" >> $GITHUB_ENV

      # Task 3: Deploy to Cloud Run
      - name: Deploy to Cloud Run
        run: |
          gcloud run deploy ${{ env.SERVICE_NAME }} \
            --image $IMAGE_URI \
            --platform managed \
            --region ${{ env.REGION }} \
            --allow-unauthenticated
```

- Click **Start commit** to save the workflow file.


## Explore the Repository 
https://github.com/ramanujds/spring-boot-cicd-cloud-run

## Find the Workflow


