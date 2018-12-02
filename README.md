# PrefsManager

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

PrefsManager is library for Android made for easy usage of SharedPreferences.

Small helper library for working with SharedPreferences.


**Note:**
 Your classes should conform to Parcelable or Serialazable 
 
 If you use parcelable in Kotlin you will need to add the experimental feature in the application build.gradle file
 ```gradle
 androidExtensions {
   experimental = true
  }
 ```
 And use it like this
 ```kotlin
@Parcelize
data class User(val userEmail: String, val userName: String) : Parcelable
 ```
 

# Simple Usage

**To keep it simple in Java we have made different functions for all the objects**

**Java:**

* Add List of Users to SharedPreferences
```java
  List<User> users = new ArrayList<User>();
  users.add(new User("user@gmail", "user"));
  users.add(new User("johndoe@gmail.com", "John Doe"));

  PrefsManager.setObject(this, "users", users);
```
* Get the Users from SharedPreferences
```java
  PrefsManager.getObject(this, "users", new TypeToken<List<User>>() {}.getType());
```
And you will get list of users like this 

```
[User(userEmail=user@gmail.com, userName=user), User(userEmail=johndoe@gmail.com, userName=John Doe)]
```
**You will need to specify TypeToken because Java doesn't provide a way to represent generic types.**

* Remove value from SharedPreferences
```java
  PrefsManager.removeValueFromPrefs(this,"user_key");
```

* Add boolean value to SharedPreferences
```java
  PrefsManager.setBooleanValue(this, "did_launch", false);
```
* And to retrieve the boolean value *(the third argument is default value)*
```java
  PrefsManager.getBooleanValue(this, "did_launch", true);
```

 
In Kotlin you can use extensions or the *Java* static functions, simple usage follows for **Kotlin** :)

**Kotlin Extensions:**

* Add value to SharedPreferences

```kotlin
  val userList = mutableListOf<User>()
  userList.add(User("user@gmail.com", "user"))
  userList.add(User("johndoe@gmail.com", "John Doe"))
    
  setValueToPrefs(this, "users", userList)
```

* Get value from SharedPreferences

```kotlin
  getValueFromPrefs<MutableList<User>>(this, "users")?.apply {
      //Do something with the users lis
      Log.i("USER", this[0].toString())
    }
```

* Remove value from SharedPreferences

```kotlin
 removeValueFromPrefs(this, "users")
```
If you want to specify default value if the key doesn't exists you can do something like this

```kotlin
  getValueFromPrefs<MutableList<User>?>(this, "users", null).apply {
      //The users may be null
      Log.i("USER", "$this")
    }
```
You need to add ``` ? ``` to make the value optional

# Download
1. Add JitPack to your project build.gradle
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
   }
}
```
2. Add the dependency in the application build.gradle
```gradle
dependencies {
    implementation 'com.github.martinstamenkovski:prefsmanager:1.1.1'
  }
```
