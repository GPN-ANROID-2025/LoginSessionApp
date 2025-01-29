# Day 10 : LoginSessionApp

```markdown
# Android Development Notes

## SharedPreferences
Used to store key-value pairs persistently.



## Pattern Matcher (Regex)
Used to validate patterns in strings.

Example:
```java
String regex = "\\d{3}-\\d{2}-\\d{4}"; // Example: 123-45-6789
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher("123-45-6789");
if (matcher.matches()) {
    System.out.println("Valid format");
}
```

## TextInputLayout & TextInputEditText
Used for material design text input fields.

Example:
```xml
<com.google.android.material.textfield.TextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter text">
    
    <com.google.android.material.textfield.TextInputEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</com.google.android.material.textfield.TextInputLayout>
```



