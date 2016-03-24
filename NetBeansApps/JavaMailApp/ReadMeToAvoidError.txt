To avoid getting the error:

"java.net.SocketException: Permission denied: connect"

Do the following (http://stackoverflow.com/questions/8360913/weird-java-net-socketexception-permission-denied-connect-error-when-running-groo):

There is a known bug in JDK 1.7 related to IPv6.
Adding -Djava.net.preferIPv4Stack=true in VM Options should fix the problem.

For NetBeans, go to the project, right click, and select Properties.
Go to the Run categories, and put the string "-Djava.net.preferIPv4Stack=true" in the VM Options.

