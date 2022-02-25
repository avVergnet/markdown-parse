public class backup {
    if(markdown.charAt(markdownCheck) == ('(')) {

        int openParen = markdown.indexOf("(", nextCloseBracket);
        int closeParen = markdown.indexOf(")", openParen);

        if((openParen == -1) || (closeParen == -1)) {
            break;
        }

        toReturn.add(markdown.substring(openParen + 1, closeParen));
        currentIndex = closeParen + 1;
    }
    else {
        currentIndex = markdownCheck;
    }
}
