## **To Make a File Public (Using GCP Console)**

### Step 1: Go to Cloud Storage in Console

1. Open [GCP Console](https://console.cloud.google.com/)
2. Navigate to **Storage** → **Browser**
3. Click on the name of your **bucket**
4. Browse and find your **file**

---

### Step 2: Make the File Public

1. Click the **three-dot menu (⋮)** next to the file
2. Select **Edit permissions**
3. Click **+ Add entry**
4. In the **Principal** field, type:

   ```
   allUsers
   ```
5. In the **Access** field, select:

   ```
   Reader
   ```
6. Click **Save**

Your file is now **publicly accessible**.

---

### Step 3: Get the Public URL

1. After setting permissions, click the file name
2. In the file details page, copy the **"Public URL"**

   ```
   https://storage.googleapis.com/your-bucket-name/your-file-name
   ```
3. Paste it in a browser – it should open/download the file without login

---

## Example

Say you have:

* Bucket: `my-static-assets`
* File: `logo.png`

After you make it public, it will be available at:

```
https://storage.googleapis.com/my-static-assets/logo.png
```

---

## To Revoke Public Access (Using Console)

1. Go to the file → **Edit permissions**
2. Remove the `allUsers` entry
3. Save the changes

This makes the file private again (only accessible to authorized users).

