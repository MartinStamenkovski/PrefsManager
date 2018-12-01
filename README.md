# PrefsManager
PrefsManager is library for Android made for easy usage of SharedPreferences.

Small helper library for working with SharedPreferences.

Simple usage:

*Java:*

Setting value to SharedPreferences
```java
  PrefsManager.setValueToPrefs(this, "user_key", new User("user@example.com", "John Doe"));
```
Getting value from SharedPreferences
```java
  PrefsManager.getValueFromPrefs(this, "user_key", User.class)
```
Removing value from SharedPreferences
```java
  PrefsManager.removeValueFromPrefs(this,"user_key");
```
**We will handle Serialization and Deserialization of your object to return the correct values**

**Note:**
 Your classes should conform to Parcelable or Serialazable 
 
In kotlin you can use extensions or the *Java* static functions simple usage follows for **Kotlin** :)

**Kotlin**
