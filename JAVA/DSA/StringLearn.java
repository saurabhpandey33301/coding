import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ==========================================================================
 *  JAVA STRING — COMPLETE MASTER REFERENCE
 *  (Everything: String, StringBuilder, StringBuffer, Regex, Character API,
 *   memory model, interview theory, and 30+ coding questions)
 * ==========================================================================
 *
 *  HOW TO USE THIS FILE:
 *  Read top to bottom once. Every section prints its own output, and every
 *  concept has a comment explaining WHY it behaves that way, not just WHAT
 *  it does. The interview-question section at the bottom is meant to be
 *  practiced separately — try solving each one yourself before reading the
 *  provided solution.
 */
public class StringLearn {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      JAVA STRING COMPLETE GUIDE");
        System.out.println("======================================");

        /*
        =====================================================
        1. Creating Strings + MEMORY MODEL (Heap vs String Pool)
        =====================================================

        JAVA MEMORY DIAGRAM (ASCII):

          STRING POOL (special area inside the Heap, in Java 7+)
          +--------------------------------------+
          |  "Saurabh"  <-------------------+     |
          |  "Java"                         |     |
          |  "Hello"                        |     |
          +----------------------------------|----+
                                              |
          HEAP (general object storage)       |
          +----------------------------------|----+
          |  new String("Pandey")  -> object   |    |
          |  new String("Hello")   -> object   |    |
          +--------------------------------------+

          STACK (method call frame, holds local variable references)
          +--------------------------------------+
          |  firstName ----> points into String Pool ("Saurabh")
          |  lastName  ----> points into Heap object ("Pandey")
          +--------------------------------------+

        RULE: A String LITERAL ("text") is placed in the String Pool and
        reused if an identical literal already exists there. A String
        created with "new String(...)" ALWAYS creates a brand-new object
        on the heap, even if an identical value already exists in the pool.
        */

        // String Literal (Stored in String Pool)
        String firstName = "Saurabh";

        // Using new keyword (Stored in Heap, NOT reused from pool)
        String lastName = new String("Pandey");

        System.out.println("\n1. Creating Strings");
        System.out.println(firstName);
        System.out.println(lastName);

        // Other ways to create a String
        char[] charArr = {'J', 'a', 'v', 'a'};
        String fromCharArray = new String(charArr);
        String fromCharArrayStatic = String.valueOf(charArr);
        System.out.println("From char[] : " + fromCharArray);
        System.out.println("From char[] via valueOf : " + fromCharArrayStatic);

        /*
        =====================================================
        2. Concatenation
        =====================================================
        Ways to concatenate: "+", concat(), StringBuilder, String.join(),
        String.format(). Each "+" on Strings inside a loop silently creates
        a NEW String object every time (because String is immutable) —
        this is why StringBuilder is preferred for loops (see Section 15).
        */

        System.out.println("\n2. Concatenation");

        String fullName = firstName + " " + lastName;   // uses "+" (compiler converts this to StringBuilder internally for a SINGLE statement)
        System.out.println(fullName);

        System.out.println(firstName.concat(" Pandey")); // concat() method - only works with Strings, throws NPE if null passed

        System.out.println(String.join("-", "2026", "07", "12")); // String.join(delimiter, ...items)

        /*
        =====================================================
        3. Every String Method — with examples
        =====================================================
        */

        String str = "Java Programming";

        System.out.println("\n3. Basic / Core String Methods");

        System.out.println("Length : " + str.length());
        System.out.println("Character at index 5 : " + str.charAt(5));
        System.out.println("Substring(5) : " + str.substring(5));            // from index 5 to end
        System.out.println("Substring(5,16) : " + str.substring(5, 16));     // [start, end) - end EXCLUSIVE
        System.out.println("Contains 'Java' : " + str.contains("Java"));
        System.out.println("Starts With 'Java' : " + str.startsWith("Java"));
        System.out.println("Ends With 'ming' : " + str.endsWith("ming"));
        System.out.println("Index of 'a' : " + str.indexOf('a'));
        System.out.println("Index of 'a' from pos 3 : " + str.indexOf('a', 3)); // overloaded: search starting at index
        System.out.println("Last Index of 'a' : " + str.lastIndexOf('a'));
        System.out.println("Upper Case : " + str.toUpperCase());
        System.out.println("Lower Case : " + str.toLowerCase());
        System.out.println("Char array : " + Arrays.toString(str.toCharArray()));
        System.out.println("codePointAt(0) : " + str.codePointAt(0));        // Unicode code point at index
        System.out.println("isEmpty() : " + str.isEmpty());
        System.out.println("matches regex '\\\\w+ \\\\w+' : " + str.matches("\\w+ \\w+")); // full-string regex match

        System.out.println("\n4. Trim / Strip");
        String spaces = "    Hello World     ";
        System.out.println("'" + spaces + "'");
        System.out.println("trim()          : '" + spaces.trim() + "'");     // removes leading/trailing ASCII whitespace (<= U+0020)
        System.out.println("strip()         : '" + spaces.strip() + "'");    // Java 11+, Unicode-aware whitespace removal (preferred over trim())
        System.out.println("stripLeading()  : '" + spaces.stripLeading() + "'");
        System.out.println("stripTrailing() : '" + spaces.stripTrailing() + "'");

        System.out.println("\n5. Replace");
        String language = "Java";
        System.out.println("replace() (literal)     : " + language.replace("Java", "Python"));
        String withDigits = "a1b2c3";
        System.out.println("replaceAll() (regex)    : " + withDigits.replaceAll("[0-9]", "#"));    // treats arg as REGEX
        System.out.println("replaceFirst() (regex)  : " + withDigits.replaceFirst("[0-9]", "#"));  // replaces only first match

        System.out.println("\n6. Split");
        String fruits = "Apple,Mango,Banana,Grapes";
        String[] arr = fruits.split(",");                 // split ACCEPTS A REGEX, not just a literal
        System.out.println(Arrays.toString(arr));
        String[] limited = fruits.split(",", 2);          // limit parameter: max number of resulting pieces
        System.out.println("split with limit=2 : " + Arrays.toString(limited));
        System.out.println("lines() (Java 11+)  : " + Arrays.toString("a\nb\nc".lines().toArray()));

        System.out.println("\n7. Repeat (Java 11+)");
        System.out.println("*".repeat(10));

        System.out.println("\n8. String Comparison");
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        System.out.println("s1 == s2 (both from pool)      : " + (s1 == s2));      // true - same pool object
        System.out.println("s1 == s3 (s3 is a new object)  : " + (s1 == s3));      // false - different heap object
        System.out.println("equals() (value comparison)    : " + s1.equals(s3));    // true - same characters
        System.out.println("equalsIgnoreCase()              : " + s1.equalsIgnoreCase("HELLO"));
        System.out.println("contentEquals(StringBuilder)    : " + s1.contentEquals(new StringBuilder("Hello"))); // compares content against any CharSequence

        System.out.println("\n9. compareTo() / compareToIgnoreCase()");
        // Lexicographic comparison: returns the DIFFERENCE between the first
        // pair of differing characters (not just -1/0/1 like C++'s strcmp).
        System.out.println("ABC vs ABC : " + "ABC".compareTo("ABC"));   // 0  (equal)
        System.out.println("ABC vs ABD : " + "ABC".compareTo("ABD"));  // -1 ('C'-'D' = -1)
        System.out.println("ABD vs ABC : " + "ABD".compareTo("ABC"));  // 1  ('D'-'C' = 1)
        System.out.println("abc vs ABC (ignore case) : " + "abc".compareToIgnoreCase("ABC")); // 0

        /*
        =====================================================
        10. String Immutability — WHY and HOW
        =====================================================
        Once a String object is created, its internal character data can
        NEVER be changed. Every method that "modifies" a String (replace,
        toUpperCase, substring, concat...) actually returns a BRAND NEW
        String object — the original is untouched.

        WHY strings are immutable (interview favorite):
          1. Security - Strings are used for class names, file paths,
             network connections; if mutable, a reference could be changed
             mid-use by another part of the program, creating security holes.
          2. String Pool reuse - pooling only works safely if the value can
             never change underneath another variable pointing to it.
          3. Thread safety - immutable objects are automatically safe to
             share across threads with no synchronization needed.
          4. Hashcode caching - since content can't change, String caches
             its hashCode() the first time it's computed (fast reuse in
             HashMaps/HashSets).
        */

        System.out.println("\n10. String Immutability");
        String animal = "Cat";
        System.out.println("Before : " + animal + " (identityHashCode=" + System.identityHashCode(animal) + ")");
        animal = "Dog"; // this does NOT change the "Cat" object - it points "animal" to a DIFFERENT object
        System.out.println("After  : " + animal + " (identityHashCode=" + System.identityHashCode(animal) + ")");

        /*
        =====================================================
        11. String Pool — deeper look
        =====================================================
        */

        System.out.println("\n11. String Pool");
        String pool1 = "Java";
        String pool2 = "Java";
        String heap = new String("Java");
        System.out.println("pool1 == pool2 (same pool slot) : " + (pool1 == pool2));  // true
        System.out.println("pool1 == heap (different object): " + (pool1 == heap));   // false
        System.out.println("pool1.equals(heap)               : " + pool1.equals(heap)); // true

        /*
        =====================================================
        12. intern() — manually pulling a String into the pool
        =====================================================
        */

        System.out.println("\n12. intern()");
        String heapString = new String("Developer");   // forced onto the heap
        String pooled = heapString.intern();            // returns the POOL's version of "Developer" (creating it if absent)
        String literal = "Developer";                    // already in the pool
        System.out.println("pooled == literal : " + (pooled == literal)); // true - both now point to the same pool object
        System.out.println("heapString == literal : " + (heapString == literal)); // false - heapString itself is untouched

        /*
        =====================================================
        13. hashCode() — how it's actually computed
        =====================================================
        String's hashCode() formula (this is literally the java.lang.String
        source code algorithm - a common interview question):

            s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]

        where s[i] is the i-th character (as an int) and n is the length.
        31 is chosen because it's an odd prime, and multiplying by 31 can
        be optimized by the JVM into (x << 5) - x, which is fast.
        Two equal Strings ALWAYS produce the same hashCode() (required for
        correct behavior in HashMap/HashSet), but two different Strings can
        (rarely) collide and share the same hashCode.
        */

        System.out.println("\n13. HashCode");
        String h1 = "Java";
        String h2 = "Java";
        System.out.println("h1.hashCode() : " + h1.hashCode());
        System.out.println("h2.hashCode() : " + h2.hashCode());
        // Manual verification of the formula for "Ja" -> 'J'=74, 'a'=97
        int manualHash = 'J' * 31 + 'a';
        System.out.println("Manual hash of \"Ja\" : " + manualHash + " | Java's hashCode(\"Ja\") : " + "Ja".hashCode());

        /*
        =====================================================
        14. Character Array conversions
        =====================================================
        */

        System.out.println("\n14. Character Array");
        char[] chars = firstName.toCharArray();
        System.out.println(Arrays.toString(chars));
        System.out.println("Rebuilt from char[] : " + new String(chars, 1, 3)); // (charArray, offset, count)

        /*
        =====================================================
        15. StringBuilder — EVERY method
        =====================================================
        StringBuilder is MUTABLE and NOT thread-safe (no synchronized
        methods) - use it for single-threaded string building, which is
        the vast majority of everyday code and ALL competitive
        programming / DSA string-building work.
        */

        System.out.println("\n15. StringBuilder");

        StringBuilder builder = new StringBuilder("Hello"); // starts with capacity = 16 + initial length
        System.out.println("Initial          : " + builder);

        builder.append(" Java");                 // adds to the end
        System.out.println("append()         : " + builder);

        builder.insert(5, ",");                  // inserts at a specific index
        System.out.println("insert()         : " + builder);

        builder.delete(5, 6);                    // deletes range [start, end)
        System.out.println("delete()         : " + builder);

        builder.deleteCharAt(0);                 // deletes a single character at index
        System.out.println("deleteCharAt()   : " + builder);
        builder.insert(0, 'H');                  // put the 'H' back for the next steps

        builder.replace(0, 5, "Hi");             // replaces range [start, end) with new text
        System.out.println("replace()        : " + builder);

        builder.reverse();                       // reverses the whole sequence in place
        System.out.println("reverse()        : " + builder);
        builder.reverse();                       // reverse back

        System.out.println("charAt(0)        : " + builder.charAt(0));
        System.out.println("indexOf(\"Java\")  : " + builder.indexOf("Java"));
        System.out.println("substring(0,2)   : " + builder.substring(0, 2));   // returns a normal String, doesn't modify builder

        System.out.println("Length           : " + builder.length());
        System.out.println("Capacity         : " + builder.capacity());       // internal char[] size (auto-grows)
        builder.ensureCapacity(100);             // requests at least this capacity (JVM may allocate more)
        System.out.println("New Capacity     : " + builder.capacity());
        builder.trimToSize();                    // shrinks capacity down to match the actual content length

        builder.setCharAt(0, 'h');               // mutate a single character in place (NOT possible on a String!)
        System.out.println("setCharAt()      : " + builder);

        builder.setLength(2);                    // truncates (or zero-pads) to exactly this length
        System.out.println("setLength(2)     : " + builder);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(1).append("-").append(2.5).append("-").append(true); // append() is overloaded for every type
        System.out.println("append() overloads : " + sb2);

        /*
        =====================================================
        16. StringBuffer — same API as StringBuilder, but SYNCHRONIZED
        =====================================================
        Every public method in StringBuffer is marked "synchronized",
        meaning only one thread can execute a method on a given
        StringBuffer instance at a time. This makes it thread-safe but
        slightly slower than StringBuilder. Use StringBuffer only when
        multiple threads truly share and mutate the same buffer.
        */

        System.out.println("\n16. StringBuffer");
        StringBuffer buffer = new StringBuffer("Programming");
        buffer.append(" Language");
        System.out.println("append()   : " + buffer);
        System.out.println("Capacity   : " + buffer.capacity());
        System.out.println("Reverse    : " + buffer.reverse());
        buffer.reverse(); // restore order
        buffer.insert(0, ">> ");
        System.out.println("insert()   : " + buffer);
        buffer.deleteCharAt(0);
        System.out.println("deleteCharAt() : " + buffer);

        /*
        =====================================================
        17. Conversion — String <-> primitives
        =====================================================
        */

        System.out.println("\n17. Conversion");
        int number = 100;
        String numString = String.valueOf(number);      // any type -> String
        System.out.println("valueOf(int) : " + numString);
        System.out.println("valueOf(double) : " + String.valueOf(3.14));
        System.out.println("valueOf(boolean) : " + String.valueOf(true));

        int again = Integer.parseInt(numString);         // String -> int (throws NumberFormatException on bad input)
        double asDouble = Double.parseDouble("3.14");     // String -> double
        long asLong = Long.parseLong("123456789012");     // String -> long
        System.out.println("parseInt : " + again + " | parseDouble : " + asDouble + " | parseLong : " + asLong);

        /*
        =====================================================
        18. Empty vs Blank
        =====================================================
        */

        System.out.println("\n18. Empty vs Blank");
        String empty = "";
        String blank = "     ";
        System.out.println("empty.isEmpty() : " + empty.isEmpty());   // true - length == 0
        System.out.println("blank.isEmpty() : " + blank.isEmpty());   // false - it HAS characters (spaces)
        System.out.println("blank.isBlank() : " + blank.isBlank());   // true (Java 11+) - only whitespace

        /*
        =====================================================
        19. Escape Characters
        =====================================================
        */

        System.out.println("\n19. Escape Characters");
        System.out.println("Hello\nWorld");     // \n  = newline
        System.out.println("Hello\tWorld");     // \t  = tab
        System.out.println("\"Java\"");          // \"  = literal double quote
        System.out.println("C:\\Users\\Saurabh"); // \\  = literal backslash
        System.out.println("\u0041");            //  \ u  = unicode escape (0041 = 'A')

        /*
        =====================================================
        20. String Formatting
        =====================================================
        Three equivalent ways to format text with placeholders.
        */

        System.out.println("\n20. String Formatting");
        String formatted1 = String.format("Name: %s, Age: %d, Score: %.2f", "Saurabh", 25, 91.567);
        System.out.println(formatted1);
        System.out.printf("printf directly -> Name: %s, Age: %d%n", "Saurabh", 25); // printf writes directly to System.out
        String formatted2 = "Name: %s, Age: %d".formatted("Saurabh", 25); // Java 15+ instance method, same as String.format
        System.out.println(formatted2);

        /*
        =====================================================
        21. StringJoiner
        =====================================================
        Like StringBuilder, but purpose-built for joining items with a
        delimiter plus an optional prefix/suffix wrapper.
        */

        System.out.println("\n21. StringJoiner");
        StringJoiner joiner = new StringJoiner(", ", "[", "]"); // (delimiter, prefix, suffix)
        joiner.add("Apple").add("Mango").add("Banana");
        System.out.println(joiner);

        /*
        =====================================================
        22. StringTokenizer (legacy, pre-dates split())
        =====================================================
        Older utility for breaking a string into tokens by delimiter
        characters. split() with regex is generally preferred today, but
        StringTokenizer is still commonly used in competitive programming
        because it's slightly faster for simple whitespace/character splits.
        */

        System.out.println("\n22. StringTokenizer");
        StringTokenizer tokenizer = new StringTokenizer("Java Is Fun", " ");
        while (tokenizer.hasMoreTokens()) {
            System.out.println("Token: " + tokenizer.nextToken());
        }

        /*
        =====================================================
        23. Character class API (java.lang.Character)
        =====================================================
        Useful static helper methods for classifying/converting a single
        char — extremely common in string-parsing DSA problems.
        */

        System.out.println("\n23. Character API");
        char sample = 'a';
        System.out.println("isDigit('5')      : " + Character.isDigit('5'));
        System.out.println("isLetter('a')     : " + Character.isLetter(sample));
        System.out.println("isUpperCase('A')  : " + Character.isUpperCase('A'));
        System.out.println("isLowerCase('a')  : " + Character.isLowerCase(sample));
        System.out.println("isWhitespace(' ') : " + Character.isWhitespace(' '));
        System.out.println("isLetterOrDigit('_') : " + Character.isLetterOrDigit('_'));
        System.out.println("toUpperCase('a')  : " + Character.toUpperCase(sample));
        System.out.println("toLowerCase('A')  : " + Character.toLowerCase('A'));
        System.out.println("getNumericValue('7') : " + Character.getNumericValue('7'));

        /*
        =====================================================
        24. Unicode & UTF-16 basics
        =====================================================
        Java's char is a 16-bit UTF-16 code unit. Most common characters
        (Latin letters, digits) fit in one char. Characters outside the
        Basic Multilingual Plane (like many emoji) need TWO chars (a
        "surrogate pair") to represent one visible character — which is
        why str.length() can be misleading for emoji-heavy text, and why
        codePointAt()/codePointCount() exist to handle real Unicode
        characters correctly instead of raw 16-bit units.
        */

        System.out.println("\n24. Unicode");
        String emoji = "Hi\uD83D\uDE00";  // "Hi" + a grinning-face emoji (surrogate pair)
        System.out.println("String       : " + emoji);
        System.out.println("length()     : " + emoji.length());          // counts UTF-16 units (4: H,i,+2 surrogate units) not visible characters
        System.out.println("codePointCount : " + emoji.codePointCount(0, emoji.length())); // counts actual Unicode characters (3)

        /*
        =====================================================
        25. Regex — Pattern & Matcher
        =====================================================
        String.matches()/replaceAll()/split() cover simple cases, but for
        reusable or advanced regex work, use Pattern (a compiled regex) and
        Matcher (an engine that applies that regex to specific text).
        Compiling once with Pattern.compile() and reusing it is faster than
        calling str.matches(regex) repeatedly, since matches() recompiles
        the regex every single call.
        */

        System.out.println("\n25. Regex - Pattern & Matcher");
        Pattern pattern = Pattern.compile("\\d+");     // one or more digits
        Matcher matcher = pattern.matcher("Order 12 has 5 items, total $340");
        while (matcher.find()) {
            System.out.println("Found number: " + matcher.group());
        }
        System.out.println("Full match test: " + Pattern.matches("[a-z]+@[a-z]+\\.com", "test@mail.com"));

        /*
        =====================================================
        26. Time Complexity Table (comment reference)
        =====================================================

        | Operation                     | String   | StringBuilder |
        |--------------------------------|----------|---------------|
        | charAt(i)                      | O(1)     | O(1)          |
        | length()                       | O(1)     | O(1)          |
        | concatenation ("+") once       | O(n)     | N/A           |
        | concatenation in a loop (n times) | O(n^2)| O(n) amortized|
        | substring()                    | O(n)     | O(n)          |
        | indexOf() / contains()         | O(n)     | O(n)          |
        | equals()                       | O(n)     | N/A           |
        | append()                       | N/A      | O(1) amortized|
        | insert() / delete()            | N/A      | O(n)          |
        | reverse()                      | N/A      | O(n)          |
        | toString()                     | N/A      | O(n)          |

        KEY TAKEAWAY: String concatenation inside a loop is O(n^2) overall
        because every "+" creates a brand-new String and copies all
        previous characters into it. StringBuilder.append() avoids this by
        mutating one internal buffer, giving O(n) total for n appends.
        */

        System.out.println("\n26. (see time complexity table in comments above)");

        /*
        =====================================================
        27. Best Practices
        =====================================================
        1. Use StringBuilder for concatenation inside loops, never "+".
        2. Always compare String content with equals()/equalsIgnoreCase(),
           never ==.
        3. Prefer strip()/isBlank() (Unicode-aware, Java 11+) over
           trim()/isEmpty() when checking for "meaningfully empty" text.
        4. Avoid "new String(\"literal\")" - it wastes memory by forcing a
           duplicate heap object instead of reusing the pool.
        5. Compile a Pattern once and reuse the Matcher instead of calling
           matches()/replaceAll() with a fresh regex string repeatedly in
           a loop.
        6. Use String.format()/formatted() for readability when building
           strings with many interpolated values, instead of long "+" chains.
        7. Be careful with locale-sensitive methods (toUpperCase(),
           toLowerCase()) in internationalized apps - pass a Locale
           explicitly if behavior must be consistent across regions.
        */

        System.out.println("\n27. (see best practices in comments above)");

        /*
        =====================================================
        28. Frequently Asked Interview Questions (theory)
        =====================================================
        Q1. Why is String immutable in Java?
            -> Security, String Pool safety, thread safety, hashCode caching.
        Q2. Difference between String, StringBuilder, StringBuffer?
            -> String: immutable. StringBuilder: mutable, not thread-safe,
               fastest. StringBuffer: mutable, thread-safe (synchronized),
               slightly slower.
        Q3. Difference between == and equals() for Strings?
            -> == compares references (memory identity); equals() compares
               actual character content.
        Q4. What is the String Constant Pool?
            -> A special memory region (inside the Heap since Java 7) that
               stores unique String literals so identical literals can be
               reused instead of duplicated.
        Q5. What does intern() do?
            -> Returns the pooled reference for a String's value, adding it
               to the pool first if not already present.
        Q6. Why does String's hashCode() formula use 31?
            -> 31 is an odd prime; multiplying by it is fast (JVM optimizes
               it to a shift+subtract) and it spreads hash values well.
        Q7. Is String thread-safe?
            -> Yes, inherently, because it's immutable - no thread can ever
               change its state.
        Q8. What happens when you compare two String objects created with
            "new" using ==?
            -> Always false, because "new" always allocates a distinct heap
               object, regardless of whether the same value exists elsewhere.
        Q9. How would you reverse a String without StringBuilder?
            -> Convert to a char[] with toCharArray(), swap characters from
               both ends inward, then rebuild with new String(charArray).
        Q10. What's the time complexity of String concatenation in a loop,
             and how do you fix it?
            -> O(n^2) using "+"; fix with StringBuilder for O(n) total.
        */

        System.out.println("\n28. (see interview theory Q&A in comments above)");

        System.out.println("\n29. Interview Coding Questions (30+) - see methods below main()");
        runInterviewQuestionDemos();

        /*
        =====================================================
        30. Consolidated Interview Notes
        =====================================================

        1. String is Immutable.
        2. StringBuilder is Mutable and NOT Thread Safe.
        3. StringBuffer is Mutable and Thread Safe.
        4. String literals are stored inside the String Pool.
        5. '==' compares references.
        6. equals() compares actual contents.
        7. compareTo() performs lexicographical comparison (returns char
           difference, not just -1/0/1).
        8. StringBuilder is preferred for repeated concatenation.
        9. String objects cannot be modified after creation.
        10. String implements Serializable, Comparable<String>, CharSequence.
        11. StringBuilder/StringBuffer default capacity = 16 + initial length.
        12. String Pool avoids duplicate String objects.
        13. intern() moves/reuses a String from the Pool.
        14. hashCode() depends only on String contents (equal strings ->
            equal hashCodes; the reverse is not guaranteed).
        15. Java Strings are UTF-16 encoded internally.
        16. matches()/replaceAll()/replaceFirst()/split() treat their
            argument as a REGEX, not a literal - escape special characters
            (like "." or "|") if you mean them literally.
        17. Character comparisons and classification belong to
            java.lang.Character (isDigit, isLetter, etc.), not String.
        18. Pattern.compile() once + reuse Matcher is faster than repeated
            String.matches() calls with the same regex.
        =====================================================
        */

        System.out.println("\n============= END =============");
    }

    // ======================================================================
    // 29. INTERVIEW CODING QUESTIONS (30+)
    // Each method is a self-contained, classic String interview question.
    // Try solving each one yourself first, then compare with this solution.
    // ======================================================================

    static void runInterviewQuestionDemos() {
        System.out.println("Q1  reverseString('hello')            = " + reverseString("hello"));
        System.out.println("Q2  isPalindrome('madam')             = " + isPalindrome("madam"));
        System.out.println("Q3  countVowels('Programming')        = " + countVowels("Programming"));
        System.out.println("Q4  firstNonRepeatingChar('swiss')    = " + firstNonRepeatingChar("swiss"));
        System.out.println("Q5  isAnagram('listen','silent')      = " + isAnagram("listen", "silent"));
        System.out.println("Q6  removeDuplicates('programming')   = " + removeDuplicates("programming"));
        System.out.println("Q7  countOccurrences('banana','a')    = " + countOccurrences("banana", 'a'));
        System.out.println("Q8  longestSubstringNoRepeat('abcabcbb') = " + longestSubstringNoRepeat("abcabcbb"));
        System.out.println("Q9  isRotation('waterbottle','erbottlewat') = " + isRotation("waterbottle", "erbottlewat"));
        System.out.println("Q10 compressString('aaabbbccd')       = " + compressString("aaabbbccd"));
        System.out.println("Q11 areAnagramsUsingSort('race','care')= " + areAnagramsUsingSort("race", "care"));
        System.out.println("Q12 reverseWordsInSentence('Java is fun') = " + reverseWordsInSentence("Java is fun"));
        System.out.println("Q13 isPermutationOfPalindrome('carrace') = " + isPermutationOfPalindrome("carrace"));
        System.out.println("Q14 countWords('  Java  is   fun ')   = " + countWords("  Java  is   fun "));
        System.out.println("Q15 toTitleCase('the quick brown fox')= " + toTitleCase("the quick brown fox"));
        System.out.println("Q16 findAllDuplicateChars('programming') = " + findAllDuplicateChars("programming"));
        System.out.println("Q17 isNumeric('12345')                = " + isNumeric("12345"));
        System.out.println("Q18 longestPalindromicSubstring('babad') = " + longestPalindromicSubstring("babad"));
        System.out.println("Q19 removeWhitespace('  a b  c ')     = '" + removeWhitespace("  a b  c ") + "'");
        System.out.println("Q20 charFrequencyMap('aabbbcc')       = " + charFrequencyMap("aabbbcc"));
        System.out.println("Q21 isValidShuffle('abc','def','adbecf') = " + isValidShuffle("abc", "def", "adbecf"));
        System.out.println("Q22 toggleCase('Hello World')         = " + toggleCase("Hello World"));
        System.out.println("Q23 findLongestWord('The quick brown fox jumped') = " + findLongestWord("The quick brown fox jumped"));
        System.out.println("Q24 areStringsRotationsOfEachOther('abcd','cdab') = " + isRotation("abcd", "cdab"));
        System.out.println("Q25 removeGivenChars('hello world','lo') = " + removeGivenChars("hello world", "lo"));
        System.out.println("Q26 firstUniqueCharIndex('leetcode')   = " + firstUniqueCharIndex("leetcode"));
        System.out.println("Q27 isStringRotationPalindrome('aab')  = " + canFormPalindrome("aab"));
        System.out.println("Q28 runLengthEncode('aaabbc')          = " + runLengthEncode("aaabbc"));
        System.out.println("Q29 countSubstringOccurrences('abababab','ab') = " + countSubstringOccurrences("abababab", "ab"));
        System.out.println("Q30 capitalizeEachWord('java string guide') = " + toTitleCase("java string guide"));
        System.out.println("Q31 removeConsecutiveDuplicates('aaabccdd') = " + removeConsecutiveDuplicates("aaabccdd"));
        System.out.println("Q32 isSubsequence('abc','ahbgdc')      = " + isSubsequence("abc", "ahbgdc"));
    }

    // Q1: Reverse a string without using StringBuilder.reverse()
    static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // Q2: Check if a string is a palindrome
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Q3: Count vowels in a string
    static int countVowels(String s) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) count++;
        }
        return count;
    }

    // Q4: Find the first non-repeating character
    static Character firstNonRepeatingChar(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        for (char c : s.toCharArray()) {
            if (freq[c] == 1) return c;
        }
        return null;
    }

    // Q5: Check if two strings are anagrams (frequency-count approach, O(n))
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] freq = new int[256];
        for (char c : a.toCharArray()) freq[c]++;
        for (char c : b.toCharArray()) freq[c]--;
        for (int f : freq) if (f != 0) return false;
        return true;
    }

    // Q6: Remove duplicate characters, keeping first occurrence order
    static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[256];
        for (char c : s.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Q7: Count occurrences of a specific character
    static int countOccurrences(String s, char target) {
        int count = 0;
        for (char c : s.toCharArray()) if (c == target) count++;
        return count;
    }

    // Q8: Longest substring without repeating characters (sliding window)
    static int longestSubstringNoRepeat(String s) {
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);
        int start = 0, maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (lastSeen[c] >= start) {
                start = lastSeen[c] + 1;
            }
            lastSeen[c] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    // Q9: Check if one string is a rotation of another (in O(n) using concatenation trick)
    static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }

    // Q10: Basic run-length compression ("aaabbbccd" -> "a3b3c2d1")
    static String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
            sb.append(c).append(count);
        }
        return sb.toString();
    }

    // Q11: Anagram check via sorting approach (O(n log n), simpler but slower than Q5)
    static boolean areAnagramsUsingSort(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);
    }

    // Q12: Reverse the ORDER of words in a sentence (not each word itself)
    static String reverseWordsInSentence(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

    // Q13: Check if a string's characters can be rearranged into a palindrome
    static boolean isPermutationOfPalindrome(String s) {
        int[] freq = new int[256];
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) freq[c]++;
        }
        int oddCount = 0;
        for (int f : freq) if (f % 2 != 0) oddCount++;
        return oddCount <= 1; // at most one character may have an odd count
    }

    // Q14: Count words in a sentence with irregular spacing
    static int countWords(String s) {
        String trimmed = s.trim();
        if (trimmed.isEmpty()) return 0;
        return trimmed.split("\\s+").length;
    }

    // Q15: Convert a sentence to Title Case
    static String toTitleCase(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Q16: Find all characters that repeat more than once
    static String findAllDuplicateChars(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 1) sb.append((char) i);
        }
        return sb.toString();
    }

    // Q17: Check if a string contains only digits
    static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // Q18: Longest palindromic substring (expand-around-center approach)
    static String longestPalindromicSubstring(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, maxLen = 1;
        for (int center = 0; center < s.length(); center++) {
            int len1 = expandAroundCenter(s, center, center);     // odd-length palindromes
            int len2 = expandAroundCenter(s, center, center + 1); // even-length palindromes
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = center - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // Q19: Remove all whitespace from a string
    static String removeWhitespace(String s) {
        return s.replaceAll("\\s+", "");
    }

    // Q20: Build a character-frequency map as a readable string
    static String charFrequencyMap(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) sb.append((char) i).append("=").append(freq[i]).append(", ");
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2); // trim trailing ", "
        return sb.append("}").toString();
    }

    // Q21: Check if "result" is a valid interleaving (shuffle) of s1 and s2
    static boolean isValidShuffle(String s1, String s2, String result) {
        if (s1.length() + s2.length() != result.length()) return false;
        return isValidShuffleHelper(s1, s2, result, 0, 0, 0);
    }

    private static boolean isValidShuffleHelper(String s1, String s2, String res, int i, int j, int k) {
        if (k == res.length()) return i == s1.length() && j == s2.length();
        boolean useS1 = i < s1.length() && s1.charAt(i) == res.charAt(k)
                && isValidShuffleHelper(s1, s2, res, i + 1, j, k + 1);
        if (useS1) return true;
        return j < s2.length() && s2.charAt(j) == res.charAt(k)
                && isValidShuffleHelper(s1, s2, res, i, j + 1, k + 1);
    }

    // Q22: Toggle the case of every letter in a string
    static String toggleCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else sb.append(c);
        }
        return sb.toString();
    }

    // Q23: Find the longest word in a sentence
    static String findLongestWord(String s) {
        String[] words = s.split("\\s+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }
        return longest;
    }

    // Q25: Remove all characters in "charsToRemove" from the source string
    static String removeGivenChars(String source, String charsToRemove) {
        boolean[] remove = new boolean[256];
        for (char c : charsToRemove.toCharArray()) remove[c] = true;
        StringBuilder sb = new StringBuilder();
        for (char c : source.toCharArray()) {
            if (!remove[c]) sb.append(c);
        }
        return sb.toString();
    }

    // Q26: Index of the first non-repeating character (returns -1 if none)
    static int firstUniqueCharIndex(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) return i;
        }
        return -1;
    }

    // Q27: Can the characters be rearranged to form a palindrome? (reuses Q13 logic idea)
    static boolean canFormPalindrome(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        int oddCount = 0;
        for (int f : freq) if (f % 2 != 0) oddCount++;
        return oddCount <= 1;
    }

    // Q28: Run-length encoding returned as compact pairs, e.g. "aaabbc" -> "a3b2c1"
    static String runLengthEncode(String s) {
        return compressString(s); // same technique as Q10, included here under its formal DSA name
    }

    // Q29: Count (possibly overlapping) occurrences of a substring
    static int countSubstringOccurrences(String s, String sub) {
        int count = 0, index = 0;
        while ((index = s.indexOf(sub, index)) != -1) {
            count++;
            index++; // move forward by 1 to allow overlapping matches
        }
        return count;
    }

    // Q31: Remove consecutive duplicate characters only (not all duplicates)
    static String removeConsecutiveDuplicates(String s) {
        if (s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Q32: Check if "sub" is a subsequence of "s" (characters in order, not necessarily contiguous)
    static boolean isSubsequence(String sub, String s) {
        int i = 0, j = 0;
        while (i < sub.length() && j < s.length()) {
            if (sub.charAt(i) == s.charAt(j)) i++;
            j++;
        }
        return i == sub.length();
    }
}

/*
 * ==========================================================================
 *  ADDITIONAL PRACTICE QUESTIONS (try these yourself - not solved above)
 * ==========================================================================
 * 33. Find the minimum window substring containing all characters of another string.
 * 34. Group a list of Strings into anagram groups.
 * 35. Implement your own version of String.indexOf() (naive substring search).
 * 36. Implement the KMP algorithm for substring search in O(n + m).
 * 37. Check if two strings are "one edit" apart (insert/delete/replace one char).
 * 38. Find the length of the longest common prefix among an array of strings.
 * 39. Convert a Roman numeral string to an integer, and vice versa.
 * 40. Justify a paragraph of text to a fixed line width (like a text editor).
 *
 * TIP: For 33, 36, and 40, look up "sliding window", "KMP algorithm", and
 * "text justification" respectively once you've attempted your own solution.
 */
