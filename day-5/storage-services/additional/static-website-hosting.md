## What is a Static Website?

A **static website** contains fixed content — no server-side processing like PHP or Node.js. It usually includes:

* `index.html`
* `styles.css`
* `script.js`
* images, fonts, etc.

---

## How to Host a Static Website on GCS (Step-by-Step Using Console)

### Step 1: Prepare Your Website Files

You need a folder with at least:

* `index.html` (homepage)
* `404.html` (optional, for error handling)
* Any CSS/JS/image files

> You can build your own or use a sample static site.

---

### Step 2: Create a Storage Bucket

1. Go to [Cloud Console → Storage → Browser](https://console.cloud.google.com/storage/browser)
2. Click **"Create bucket"**
3. Bucket name **must match your domain** if you plan to map it (e.g., `www.mywebsite.com`)
4. Choose:

    * **Location**: Multi-region (e.g., `us`)
    * **Default storage class**: Standard
    * **Access Control**: **Uniform** (recommended)
5. Click **Create**

---

### Step 3: Upload Website Files

1. Open the bucket
2. Click **"Upload files"** or **"Upload folder"**
3. Upload your `index.html`, `404.html`, and assets

---

### Step 4: Make Files Public

> GCS doesn’t auto-serve public files unless permissions are set.

1. Go to the **Permissions** tab of your bucket
2. Click **"Grant Access"**
3. Enter:

    * **New principal**: `allUsers`
    * **Role**: `Storage Object Viewer`
4. Click **Save**

This allows anyone to read the files in the bucket.

---

### Step 5: Set Up Static Website Hosting

1. Click on **"Edit website configuration"** in the bucket settings
2. Enter:

    * **Main page**: `index.html`
    * **404 page (optional)**: `404.html`
3. Save the settings

---

### Step 6: Get the Website URL

Your site is now accessible at:

```
https://storage.googleapis.com/BUCKET_NAME/index.html
```

For example:

```
https://storage.googleapis.com/my-static-site/index.html
```

---

## (Optional) Use a Custom Domain (e.g., [www.example.com](http://www.example.com))

1. Your bucket name **must match** the domain (e.g., `www.example.com`)
2. Verify domain ownership in **Search Console**
3. Set up **CNAME records** in your domain's DNS to point to:

   ```
   c.storage.googleapis.com
   ```
4. Use **Cloud CDN + HTTPS** via Cloud Load Balancer if you want HTTPS support with a custom domain.

---

## Best Practices

* Use **Uniform bucket-level access**
* Organize content in folders if needed
* Set **cache-control headers** for better performance
* Use **Cloud CDN** for faster delivery if serving globally
* Keep backup copies of your files locally

---

## Summary

| Step | Action                                                |
| ---- | ----------------------------------------------------- |
| 1    | Create a GCS bucket                                   |
| 2    | Upload static website files                           |
| 3    | Make files publicly accessible                        |
| 4    | Configure website settings (`index.html`, `404.html`) |
| 5    | (Optional) Map a custom domain                        |


