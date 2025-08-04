
##  What Is Firestore?

**Cloud Firestore** is a serverless, NoSQL document database offered by Google. It stores data as **collections** and **documents**, not as tables and rows like traditional databases.

* **Collection** = a group of documents
* **Document** = a single record (like a user or blog post)
* **Field** = a key-value pair inside a document (e.g., name: "John")

---

## Step-by-Step Setup (Using GCP Console / Firebase Console)

### Step 1: Open Firebase Console

* Go to: [https://console.firebase.google.com](https://console.firebase.google.com)
* Click **Add project** or select an existing project.

### Step 2: Set Up Firestore Database

1. In the left menu, click **Build > Firestore Database**.
2. Click the **Create database** button.
3. Choose **Start in test mode** (good for development).
4. Select your **Cloud region** (ideally where your app or users are).
5. Click **Enable**.

This creates an empty database with open access for development (you can restrict access later).

---

## Using the Firestore Console (No Coding)

Now let’s run some **basic operations** directly using the Firestore UI in Firebase Console.

---

### Add Data

1. Click **Start Collection**.
2. Enter a **collection ID** (e.g., `users`).
3. Create a **document**:

    * Let Firestore auto-generate a Document ID or enter your own (e.g., `user1`).
    * Add fields like:

        * `name` → "Alice"
        * `age` → 30
        * `email` → "[alice@example.com](mailto:alice@example.com)"
4. Click **Save**.

You’ve now created your first document inside a collection.

---

### View Documents

* Click on your **collection name** (e.g., `users`) on the left.
* You’ll see the list of documents.
* Click on a document to view its fields and values.

---

### Update Data

1. Open a document.
2. Click the **Edit** button next to a field.
3. Change the value (e.g., update age from 30 to 35).
4. Click **Update** to save changes.

---

###  Add More Fields

1. Open the document.
2. Click **Add field**.
3. Enter a new key (e.g., `country`) and value (e.g., `"India"`).
4. Click **Add**.

---

###  Delete Data

* **To delete a field**: Click the trash icon next to a field.
* **To delete a document**: Click the three dots next to the document ID and select **Delete document**.
* **To delete a collection**: You must delete each document first, then the collection will disappear.

---

##  Firestore Test Use Case

Let’s say you're building a simple student portal. Here’s what your Firestore data might look like:

```
Collection: students
  → Document: student1
      → Fields: name = "Ravi", age = 21, course = "CS"
  → Document: student2
      → Fields: name = "Meena", age = 22, course = "IT"
```

You can now view, add, and edit these documents visually from the console.

---

## Important Note About Security

In test mode, anyone with your Firebase project info can read/write data.

When ready to go live:

1. Go to **Firestore > Rules** tab.
2. Update rules like this:

   ```
   allow read, write: if request.auth != null;
   ```

   This means only authenticated users can access data.

---

## Summary of Operations (All via Console)

| Action              | How to Do It                                       |
| ------------------- | -------------------------------------------------- |
| Create database     | Via Firebase Console > Firestore > Create database |
| Add collection/data | Use “Start Collection” and fill fields             |
| View data           | Navigate via collections/documents in console      |
| Update data         | Click on field → Edit → Update                     |
| Delete data         | Use trash icon or document menu                    |
| Secure data         | Edit Firestore Rules in the **Rules** tab          |


