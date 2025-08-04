## Create a database

```bash

use notes_db

```

## Create a user to access notes_db

```javascript


db.createUser({
    user: "admin", pwd: "password", roles: [{
        role: "readWrite", db: "notes_db"
    }]
})

```