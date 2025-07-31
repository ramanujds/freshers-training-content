

## Implement the following

## POST 

### Check if a note with same id already there
### If yes throw an exception DuplicateRecordException
### Status Code 400/409
```java

throw new DuplicateRecordException(message);

```

### GET : /title/{title}
### Return List<Note>