# blueMykolyks

### Choices

Our group decided to use a constant run time for add because we followed what was specified in the duke api. Because add would just be adding at the end, we needed a way to remove the elements in alphabetical order. The peekMin would traverse the entire ArrayList to find the earliest String using the reigning champ method. We would then remove this value in the removeMin method, which traverses the entire ArrayList to the earliest alphabetically String. Then, you just use the built in remove method to remove this String.

Our add() is O(1)
Our peekMin() is O(n)
Our removeMin() is O(n)