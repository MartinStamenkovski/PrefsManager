# PrefsManager
PrefsManager is library for Android made for easy usage of SharedPreferences.

Small helper library for working with SharedPreferences.


**Note:**
 Your classes should conform to Parcelable or Serialazable 

Simple usage:

**To keep it simple in Java we have made different functions for all the objects**

*Java:*

Add List of Users to SharedPreferences
```java
  List<User> users = new ArrayList<User>();
  users.add(new User("user@gmail", "user"));
  users.add(new User("johndoe@gmail.com", "John Doe"));

  PrefsManager.setObject(this, "users", users);
```
Get the Users from SharedPreferences
```java
  PrefsManager.getObject(this, "users", new TypeToken<List<User>>() {}.getType());
```
And you will get list of users like this 

```JSON
[User(userEmail=user@gmail.com, userName=user), User(userEmail=johndoe@gmail.com, userName=John Doe)]
```
You will need to specify TypeToken because Java doesn't provide a way to represent generic types.

Remove value from SharedPreferences
```java
  PrefsManager.removeValueFromPrefs(this,"user_key");
```

Add boolean value to SharedPreferences
```java
  PrefsManager.setBooleanValue(this, "did_launch", false);
```
And to retrieve the boolean value *(the third argument is default value)*
```java
  PrefsManager.getBooleanValue(this, "did_launch", true);
```

 
In kotlin you can use extensions or the *Java* static functions, simple usage follows for **Kotlin** :)

**Kotlin:**

Add value to SharedPreferences

```kotlin
  val userList = mutableListOf<User>()
  userList.add(User("user@gmail.com", "user"))
  userList.add(User("johndoe@gmail.com", "John Doe"))
    
  setValueToPrefs(this, "user_list", userList)
```

Get value from SharedPreferences

```kotlin
  getValueFromPrefs<MutableList<User>>(this, "user_list")?.apply {
      //Do something with the users lis
      Log.i("USER", this[0].toString())
    }
```

Remove value from SharedPreferences

```kotlin
 removeValueFromPrefs(this, "user_list")
```
