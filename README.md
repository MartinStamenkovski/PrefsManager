# PrefsManager
PrefsManager is library for Android made for easy usage of SharedPreferences.

Small helper library for working with SharedPreferences.

Simple usage:

*Java:*

Add value to SharedPreferences
```java
  PrefsManager.setValueToPrefs(this, "user_key", new User("user@example.com", "John Doe"));
```
Get value from SharedPreferences
```java
  PrefsManager.getValueFromPrefs(this, "user_key", User.class)
```
Remove value from SharedPreferences
```java
  PrefsManager.removeValueFromPrefs(this,"user_key");
```
**Currently in Java lists are not supported**

**Note:**
 Your classes should conform to Parcelable or Serialazable 
 
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
