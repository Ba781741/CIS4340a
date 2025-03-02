public RandomAccessFile openFile(java.io.File f) {
  final java.io.File copy = new java.io.File(f.getPath());
  askUserPermission(copy.getPath());
  // ...
  return (RandomAccessFile)AccessController.doPrivileged(new PrivilegedAction <Object>() {
    public Object run() {
      return new RandomAccessFile(copy, copy.getPath());
    }
  });
}
