import java.util.Stack;

public class LRparser {

    private Stack<String> stack = new Stack<>();

    public static void main(String[] args) {

        SmallLexer smallLexer = new SmallLexer();
        smallLexer.runLexer(args);

        LRparser lRparser = new LRparser();
        lRparser.run(smallLexer);
    }
    
    
    public LRparser() {
        
        ParsingTable.addShiftTable(0, "program", 2);
        // ParsingTable.addAcceptTable(1, "$");
        ParsingTable.addShiftTable(2, "Identifier", 4);
        ParsingTable.addShiftTable(3, "begin", 6);
        ParsingTable.addReduceTable(4, "begin", 2);
        ParsingTable.addReduceTable(5, "$", 1);
        ParsingTable.addReduceTable(6, "Identifier", 29);
        ParsingTable.addShiftTable(6, "if", 20);
        ParsingTable.addShiftTable(6, "int", 21);
        ParsingTable.addShiftTable(6, "integer", 22);
        ParsingTable.addShiftTable(6, "print_line", 16);
        ParsingTable.addShiftTable(6, "display", 17);
        ParsingTable.addShiftTable(6, "for", 18);
        ParsingTable.addShiftTable(6, "while", 19);
        ParsingTable.addShiftTable(7, "end", 23);
        ParsingTable.addReduceTable(8, "Identifier", 29);
        ParsingTable.addReduceTable(8, "end", 17);
        ParsingTable.addShiftTable(8, "break", 31);
        ParsingTable.addShiftTable(8, "if", 20);
        ParsingTable.addShiftTable(8, "int", 21);
        ParsingTable.addShiftTable(8, "integer", 22);
        ParsingTable.addShiftTable(8, "print_line", 16);
        ParsingTable.addShiftTable(8, "display", 17);
        ParsingTable.addShiftTable(8, "for", 18);
        ParsingTable.addShiftTable(8, "while", 19);
        ParsingTable.addReduceTable(9, "Identifier", 29);
        ParsingTable.addReduceTable(9, "end", 17);
        ParsingTable.addShiftTable(9, "break", 31);
        ParsingTable.addShiftTable(9, "if", 20);
        ParsingTable.addShiftTable(9, "int", 21);
        ParsingTable.addShiftTable(9, "integer", 22);
        ParsingTable.addShiftTable(9, "print_line", 16);
        ParsingTable.addShiftTable(9, "display", 17);
        ParsingTable.addShiftTable(9, "for", 18);
        ParsingTable.addShiftTable(9, "while", 19);
        ParsingTable.addReduceTable(10, "Identifier", 29);
        ParsingTable.addReduceTable(10, "end", 17);
        ParsingTable.addShiftTable(10, "break", 31);
        ParsingTable.addShiftTable(10, "if", 20);
        ParsingTable.addShiftTable(10, "int", 21);
        ParsingTable.addShiftTable(10, "integer", 22);
        ParsingTable.addShiftTable(10, "print_line", 16);
        ParsingTable.addShiftTable(10, "display", 17);
        ParsingTable.addShiftTable(10, "for", 18);
        ParsingTable.addShiftTable(10, "while", 19);
        ParsingTable.addReduceTable(11, "Identifier", 29);
        ParsingTable.addReduceTable(11, "end", 17);
        ParsingTable.addShiftTable(11, "break", 31);
        ParsingTable.addShiftTable(11, "if", 20);
        ParsingTable.addShiftTable(11, "int", 21);
        ParsingTable.addShiftTable(11, "integer", 22);
        ParsingTable.addShiftTable(11, "print_line", 16);
        ParsingTable.addShiftTable(11, "display", 17);
        ParsingTable.addShiftTable(11, "for", 18);
        ParsingTable.addShiftTable(11, "while", 19);
        ParsingTable.addReduceTable(12, "Identifier", 29);
        ParsingTable.addReduceTable(12, "end", 17);
        ParsingTable.addShiftTable(12, "break", 31);
        ParsingTable.addShiftTable(12, "if", 20);
        ParsingTable.addShiftTable(12, "int", 21);
        ParsingTable.addShiftTable(12, "integer", 22);
        ParsingTable.addShiftTable(12, "print_line", 16);
        ParsingTable.addShiftTable(12, "display", 17);
        ParsingTable.addShiftTable(12, "for", 18);
        ParsingTable.addShiftTable(12, "while", 19);
        ParsingTable.addReduceTable(13, "Identifier", 29);
        ParsingTable.addReduceTable(13, "end", 17);
        ParsingTable.addShiftTable(13, "break", 31);
        ParsingTable.addShiftTable(13, "if", 20);
        ParsingTable.addShiftTable(13, "int", 21);
        ParsingTable.addShiftTable(13, "integer", 22);
        ParsingTable.addShiftTable(13, "print_line", 16);
        ParsingTable.addShiftTable(13, "display", 17);
        ParsingTable.addShiftTable(13, "for", 18);
        ParsingTable.addShiftTable(13, "while", 19);
        ParsingTable.addReduceTable(14, "Identifier", 18);
        ParsingTable.addReduceTable(14, "end", 18);
        ParsingTable.addReduceTable(14, "break", 18);
        ParsingTable.addReduceTable(14, "if", 18);
        ParsingTable.addShiftTable(14, "else_if", 39);
        ParsingTable.addShiftTable(14, "else", 40);
        ParsingTable.addReduceTable(14, "int", 18);
        ParsingTable.addReduceTable(14, "integer", 18);
        ParsingTable.addReduceTable(14, "print_line", 18);
        ParsingTable.addReduceTable(14, "display", 18);
        ParsingTable.addReduceTable(14, "for", 18);
        ParsingTable.addReduceTable(14, "while", 18);
        ParsingTable.addShiftTable(15, "Identifier", 43);
        ParsingTable.addShiftTable(16, "(", 44);
        ParsingTable.addShiftTable(17, "(", 45);
        ParsingTable.addShiftTable(18, "(", 46);
        ParsingTable.addShiftTable(19, "(", 47);
        ParsingTable.addShiftTable(20, "(", 48);
        ParsingTable.addReduceTable(21, "Identifier", 27);
        ParsingTable.addReduceTable(22, "Identifier", 28);
        ParsingTable.addReduceTable(23, "$", 3);
        ParsingTable.addReduceTable(24, "end", 4);
        ParsingTable.addReduceTable(25, "Identifier", 29);
        ParsingTable.addReduceTable(25, "end", 17);
        ParsingTable.addShiftTable(25, "break", 31);
        ParsingTable.addShiftTable(25, "if", 20);
        ParsingTable.addShiftTable(25, "int", 21);
        ParsingTable.addShiftTable(25, "integer", 22);
        ParsingTable.addShiftTable(25, "print_line", 16);
        ParsingTable.addShiftTable(25, "display", 17);
        ParsingTable.addShiftTable(25, "for", 18);
        ParsingTable.addShiftTable(25, "while", 19);
        ParsingTable.addReduceTable(26, "Identifier", 29);
        ParsingTable.addReduceTable(26, "end", 17);
        ParsingTable.addShiftTable(26, "break", 31);
        ParsingTable.addShiftTable(26, "if", 20);
        ParsingTable.addShiftTable(26, "int", 21);
        ParsingTable.addShiftTable(26, "integer", 22);
        ParsingTable.addShiftTable(26, "print_line", 16);
        ParsingTable.addShiftTable(26, "display", 17);
        ParsingTable.addShiftTable(26, "for", 18);
        ParsingTable.addShiftTable(26, "while", 19);
        ParsingTable.addReduceTable(27, "Identifier", 29);
        ParsingTable.addReduceTable(27, "end", 17);
        ParsingTable.addShiftTable(27, "break", 31);
        ParsingTable.addShiftTable(27, "if", 20);
        ParsingTable.addShiftTable(27, "int", 21);
        ParsingTable.addShiftTable(27, "integer", 22);
        ParsingTable.addShiftTable(27, "print_line", 16);
        ParsingTable.addShiftTable(27, "display", 17);
        ParsingTable.addShiftTable(27, "for", 18);
        ParsingTable.addShiftTable(27, "while", 19);
        ParsingTable.addReduceTable(28, "Identifier", 29);
        ParsingTable.addReduceTable(28, "end", 17);
        ParsingTable.addShiftTable(28, "break", 31);
        ParsingTable.addShiftTable(28, "if", 20);
        ParsingTable.addShiftTable(28, "int", 21);
        ParsingTable.addShiftTable(28, "integer", 22);
        ParsingTable.addShiftTable(28, "print_line", 16);
        ParsingTable.addShiftTable(28, "display", 17);
        ParsingTable.addShiftTable(28, "for", 18);
        ParsingTable.addShiftTable(28, "while", 19);
        ParsingTable.addReduceTable(29, "Identifier", 29);
        ParsingTable.addReduceTable(29, "end", 17);
        ParsingTable.addShiftTable(29, "break", 31);
        ParsingTable.addShiftTable(29, "if", 20);
        ParsingTable.addShiftTable(29, "int", 21);
        ParsingTable.addShiftTable(29, "integer", 22);
        ParsingTable.addShiftTable(29, "print_line", 16);
        ParsingTable.addShiftTable(29, "display", 17);
        ParsingTable.addShiftTable(29, "for", 18);
        ParsingTable.addShiftTable(29, "while", 19);
        ParsingTable.addReduceTable(30, "Identifier", 29);
        ParsingTable.addReduceTable(30, "end", 17);
        ParsingTable.addShiftTable(30, "break", 31);
        ParsingTable.addShiftTable(30, "if", 20);
        ParsingTable.addShiftTable(30, "int", 21);
        ParsingTable.addShiftTable(30, "integer", 22);
        ParsingTable.addShiftTable(30, "print_line", 16);
        ParsingTable.addShiftTable(30, "display", 17);
        ParsingTable.addShiftTable(30, "for", 18);
        ParsingTable.addShiftTable(30, "while", 19);
        ParsingTable.addShiftTable(31, ";", 55);
        ParsingTable.addReduceTable(32, "end", 5);
        ParsingTable.addReduceTable(33, "end", 6);
        ParsingTable.addReduceTable(34, "end", 7);
        ParsingTable.addReduceTable(35, "end", 8);
        ParsingTable.addReduceTable(36, "end", 9);
        ParsingTable.addReduceTable(37, "Identifier", 19);
        ParsingTable.addReduceTable(37, "end", 19);
        ParsingTable.addReduceTable(37, "break", 19);
        ParsingTable.addReduceTable(37, "if", 19);
        ParsingTable.addShiftTable(37, "else", 40);
        ParsingTable.addReduceTable(37, "int", 19);
        ParsingTable.addReduceTable(37, "integer", 19);
        ParsingTable.addReduceTable(37, "print_line", 19);
        ParsingTable.addReduceTable(37, "display", 19);
        ParsingTable.addReduceTable(37, "for", 19);
        ParsingTable.addReduceTable(37, "while", 19);
        ParsingTable.addReduceTable(38, "Identifier", 20);
        ParsingTable.addReduceTable(38, "end", 20);
        ParsingTable.addReduceTable(38, "break", 20);
        ParsingTable.addReduceTable(38, "if", 20);
        ParsingTable.addReduceTable(38, "int", 20);
        ParsingTable.addReduceTable(38, "integer", 20);
        ParsingTable.addReduceTable(38, "print_line", 20);
        ParsingTable.addReduceTable(38, "display", 20);
        ParsingTable.addReduceTable(38, "for", 20);
        ParsingTable.addReduceTable(38, "while", 20);
        ParsingTable.addShiftTable(39, "(", 57);
        ParsingTable.addShiftTable(40, "begin", 59);
        ParsingTable.addShiftTable(41, ";", 60);
        ParsingTable.addShiftTable(42, "=", 62);
        ParsingTable.addReduceTable(43, "=", 2);
        ParsingTable.addReduceTable(43, ";", 2);
        ParsingTable.addShiftTable(44, "String Literal", 64);
        ParsingTable.addShiftTable(44, "Identifier", 64);
        ParsingTable.addShiftTable(45, "String Literal", 65);
        ParsingTable.addReduceTable(46, "Identifier", 29);
        ParsingTable.addShiftTable(46, "int", 21);
        ParsingTable.addShiftTable(46, "integer", 22);
        ParsingTable.addShiftTable(47, "Identifier", 73);
        ParsingTable.addShiftTable(47, "Number Literal", 72);
        ParsingTable.addShiftTable(48, "Identifier", 73);
        ParsingTable.addShiftTable(48, "Number Literal", 72);
        ParsingTable.addReduceTable(49, "end", 10);
        ParsingTable.addReduceTable(50, "end", 11);
        ParsingTable.addReduceTable(51, "end", 12);
        ParsingTable.addReduceTable(52, "end", 13);
        ParsingTable.addReduceTable(53, "end", 14);
        ParsingTable.addReduceTable(54, "end", 15);
        ParsingTable.addReduceTable(55, "end", 16);
        ParsingTable.addReduceTable(56, "Identifier", 21);
        ParsingTable.addReduceTable(56, "end", 21);
        ParsingTable.addReduceTable(56, "break", 21);
        ParsingTable.addReduceTable(56, "if", 21);
        ParsingTable.addReduceTable(56, "int", 21);
        ParsingTable.addReduceTable(56, "integer", 21);
        ParsingTable.addReduceTable(56, "print_line", 21);
        ParsingTable.addReduceTable(56, "display", 21);
        ParsingTable.addReduceTable(56, "for", 21);
        ParsingTable.addReduceTable(56, "while", 21);
        ParsingTable.addShiftTable(57, "Identifier", 73);
        ParsingTable.addShiftTable(57, "Number Literal", 72);
        ParsingTable.addReduceTable(58, "Identifier", 26);
        ParsingTable.addReduceTable(58, "end", 26);
        ParsingTable.addReduceTable(58, "break", 26);
        ParsingTable.addReduceTable(58, "if", 26);
        ParsingTable.addReduceTable(58, "int", 26);
        ParsingTable.addReduceTable(58, "integer", 26);
        ParsingTable.addReduceTable(58, "print_line", 26);
        ParsingTable.addReduceTable(58, "display", 26);
        ParsingTable.addReduceTable(58, "for", 26);
        ParsingTable.addReduceTable(58, "while", 26);
        ParsingTable.addReduceTable(59, "Identifier", 29);
        ParsingTable.addShiftTable(59, "if", 20);
        ParsingTable.addShiftTable(59, "int", 21);
        ParsingTable.addShiftTable(59, "integer", 22);
        ParsingTable.addShiftTable(59, "print_line", 16);
        ParsingTable.addShiftTable(59, "display", 17);
        ParsingTable.addShiftTable(59, "for", 18);
        ParsingTable.addShiftTable(59, "while", 19);
        ParsingTable.addReduceTable(60, "Identifier", 31);
        ParsingTable.addReduceTable(60, "end", 31);
        ParsingTable.addReduceTable(60, "break", 31);
        ParsingTable.addReduceTable(60, "if", 31);
        ParsingTable.addReduceTable(60, "int", 31);
        ParsingTable.addReduceTable(60, "integer", 31);
        ParsingTable.addReduceTable(60, "print_line", 31);
        ParsingTable.addReduceTable(60, "display", 31);
        ParsingTable.addReduceTable(60, "for", 31);
        ParsingTable.addReduceTable(60, "while", 31);
        ParsingTable.addReduceTable(61, ";", 34);
        ParsingTable.addShiftTable(61, ",", 78);
        ParsingTable.addShiftTable(62, "Identifier", 84);
        ParsingTable.addShiftTable(62, "Number Literal", 83);
        ParsingTable.addShiftTable(63, ")", 85);
        ParsingTable.addReduceTable(64, ")", 42);
        ParsingTable.addShiftTable(65, ")", 86);
        ParsingTable.addShiftTable(66, "Identifier", 73);
        ParsingTable.addShiftTable(66, "Number Literal", 72);
        ParsingTable.addShiftTable(67, "Identifier", 43);
        ParsingTable.addShiftTable(68, ")", 90);
        ParsingTable.addShiftTable(69, ">", 92);
        ParsingTable.addShiftTable(69, "<", 93);
        ParsingTable.addShiftTable(69, "==", 94);
        ParsingTable.addShiftTable(69, "!=", 95);
        ParsingTable.addShiftTable(69, "<=", 96);
        ParsingTable.addShiftTable(69, ">=", 97);
        ParsingTable.addReduceTable(70, ">", 39);
        ParsingTable.addReduceTable(70, "<", 39);
        ParsingTable.addReduceTable(70, "==", 39);
        ParsingTable.addReduceTable(70, "!=", 39);
        ParsingTable.addReduceTable(70, "<=", 39);
        ParsingTable.addReduceTable(70, ">=", 39);
        ParsingTable.addReduceTable(71, ">", 40);
        ParsingTable.addReduceTable(71, "<", 40);
        ParsingTable.addReduceTable(71, "==", 40);
        ParsingTable.addReduceTable(71, "!=", 40);
        ParsingTable.addReduceTable(71, "<=", 40);
        ParsingTable.addReduceTable(71, ">=", 40);
        ParsingTable.addReduceTable(72, ">", 43);
        ParsingTable.addReduceTable(72, "<", 43);
        ParsingTable.addReduceTable(72, "==", 43);
        ParsingTable.addReduceTable(72, "!=", 43);
        ParsingTable.addReduceTable(72, "<=", 43);
        ParsingTable.addReduceTable(72, ">=", 43);
        ParsingTable.addReduceTable(73, ">", 2);
        ParsingTable.addReduceTable(73, "<", 2);
        ParsingTable.addReduceTable(73, "==", 2);
        ParsingTable.addReduceTable(73, "!=", 2);
        ParsingTable.addReduceTable(73, "<=", 2);
        ParsingTable.addReduceTable(73, ">=", 2);
        ParsingTable.addShiftTable(74, ")", 98);
        ParsingTable.addShiftTable(75, ")", 99);
        ParsingTable.addShiftTable(76, "end", 100);
        ParsingTable.addReduceTable(77, ";", 32);
        ParsingTable.addShiftTable(78, "Identifier", 43);
        ParsingTable.addReduceTable(79, ";", 34);
        ParsingTable.addShiftTable(79, ",", 103);
        ParsingTable.addReduceTable(80, ";", 38);
        ParsingTable.addReduceTable(80, ",", 38);
        ParsingTable.addShiftTable(80, "+", 106);
        ParsingTable.addShiftTable(80, "-", 107);
        ParsingTable.addShiftTable(80, "/", 108);
        ParsingTable.addShiftTable(80, "*", 109);
        ParsingTable.addReduceTable(81, ";", 39);
        ParsingTable.addReduceTable(81, ",", 39);
        ParsingTable.addReduceTable(81, "+", 39);
        ParsingTable.addReduceTable(81, "-", 39);
        ParsingTable.addReduceTable(81, "/", 39);
        ParsingTable.addReduceTable(81, "*", 39);
        ParsingTable.addReduceTable(82, ";", 40);
        ParsingTable.addReduceTable(82, ",", 40);
        ParsingTable.addReduceTable(82, "+", 40);
        ParsingTable.addReduceTable(82, "-", 40);
        ParsingTable.addReduceTable(82, "/", 40);
        ParsingTable.addReduceTable(82, "*", 40);
        ParsingTable.addReduceTable(83, ";", 43);
        ParsingTable.addReduceTable(83, ",", 43);
        ParsingTable.addReduceTable(83, "+", 43);
        ParsingTable.addReduceTable(83, "-", 43);
        ParsingTable.addReduceTable(83, "/", 43);
        ParsingTable.addReduceTable(83, "*", 43);
        ParsingTable.addReduceTable(84, ";", 2);
        ParsingTable.addReduceTable(84, ",", 2);
        ParsingTable.addReduceTable(84, "+", 2);
        ParsingTable.addReduceTable(84, "-", 2);
        ParsingTable.addReduceTable(84, "/", 2);
        ParsingTable.addReduceTable(84, "*", 2);
        ParsingTable.addShiftTable(85, ";", 110);
        ParsingTable.addShiftTable(86, ";", 111);
        ParsingTable.addShiftTable(87, ";", 112);
        ParsingTable.addShiftTable(88, ">", 92);
        ParsingTable.addShiftTable(88, "<", 93);
        ParsingTable.addShiftTable(88, "==", 94);
        ParsingTable.addShiftTable(88, "!=", 95);
        ParsingTable.addShiftTable(88, "<=", 96);
        ParsingTable.addShiftTable(88, ">=", 97);
        ParsingTable.addShiftTable(89, ";", 114);
        ParsingTable.addShiftTable(90, "begin", 59);
        ParsingTable.addShiftTable(91, "Identifier", 120);
        ParsingTable.addShiftTable(91, "Number Literal", 119);
        ParsingTable.addReduceTable(92, "Identifier", 44);
        ParsingTable.addReduceTable(92, "Number Literal", 44);
        ParsingTable.addReduceTable(93, "Identifier", 45);
        ParsingTable.addReduceTable(93, "Number Literal", 45);
        ParsingTable.addReduceTable(94, "Identifier", 46);
        ParsingTable.addReduceTable(94, "Number Literal", 46);
        ParsingTable.addReduceTable(95, "Identifier", 47);
        ParsingTable.addReduceTable(95, "Number Literal", 47);
        ParsingTable.addReduceTable(96, "Identifier", 48);
        ParsingTable.addReduceTable(96, "Number Literal", 48);
        ParsingTable.addReduceTable(97, "Identifier", 49);
        ParsingTable.addReduceTable(97, "Number Literal", 49);
        ParsingTable.addShiftTable(98, "begin", 122);
        ParsingTable.addShiftTable(99, "begin", 122);
        ParsingTable.addReduceTable(100, "Identifier", 3);
        ParsingTable.addReduceTable(100, "end", 3);
        ParsingTable.addReduceTable(100, "break", 3);
        ParsingTable.addReduceTable(100, "if", 3);
        ParsingTable.addReduceTable(100, "int", 3);
        ParsingTable.addReduceTable(100, "integer", 3);
        ParsingTable.addReduceTable(100, "print_line", 3);
        ParsingTable.addReduceTable(100, "display", 3);
        ParsingTable.addReduceTable(100, "for", 3);
        ParsingTable.addReduceTable(100, "while", 3);
        ParsingTable.addShiftTable(101, "=", 62);
        ParsingTable.addReduceTable(102, ";", 35);
        ParsingTable.addReduceTable(102, ",", 35);
        ParsingTable.addShiftTable(103, "Identifier", 43);
        ParsingTable.addReduceTable(104, ";", 36);
        ParsingTable.addReduceTable(104, ",", 36);
        ParsingTable.addShiftTable(105, "Identifier", 84);
        ParsingTable.addShiftTable(105, "Number Literal", 83);
        ParsingTable.addReduceTable(106, "Identifier", 50);
        ParsingTable.addReduceTable(106, "Number Literal", 50);
        ParsingTable.addReduceTable(107, "Identifier", 51);
        ParsingTable.addReduceTable(107, "Number Literal", 51);
        ParsingTable.addReduceTable(108, "Identifier", 52);
        ParsingTable.addReduceTable(108, "Number Literal", 52);
        ParsingTable.addReduceTable(109, "Identifier", 53);
        ParsingTable.addReduceTable(109, "Number Literal", 53);
        ParsingTable.addReduceTable(110, "Identifier", 41);
        ParsingTable.addReduceTable(110, "end", 41);
        ParsingTable.addReduceTable(110, "break", 41);
        ParsingTable.addReduceTable(110, "if", 41);
        ParsingTable.addReduceTable(110, "int", 41);
        ParsingTable.addReduceTable(110, "integer", 41);
        ParsingTable.addReduceTable(110, "print_line", 41);
        ParsingTable.addReduceTable(110, "display", 41);
        ParsingTable.addReduceTable(110, "for", 41);
        ParsingTable.addReduceTable(110, "while", 41);
        ParsingTable.addReduceTable(111, "Identifier", 56);
        ParsingTable.addReduceTable(111, "end", 56);
        ParsingTable.addReduceTable(111, "break", 56);
        ParsingTable.addReduceTable(111, "if", 56);
        ParsingTable.addReduceTable(111, "int", 56);
        ParsingTable.addReduceTable(111, "integer", 56);
        ParsingTable.addReduceTable(111, "print_line", 56);
        ParsingTable.addReduceTable(111, "display", 56);
        ParsingTable.addReduceTable(111, "for", 56);
        ParsingTable.addReduceTable(111, "while", 56);
        ParsingTable.addShiftTable(112, "Identifier", 128);
        ParsingTable.addShiftTable(113, "Identifier", 133);
        ParsingTable.addShiftTable(113, "Number Literal", 132);
        ParsingTable.addReduceTable(114, "Identifier", 31);
        ParsingTable.addReduceTable(114, "Number Literal", 31);
        ParsingTable.addReduceTable(115, "Identifier", 58);
        ParsingTable.addReduceTable(115, "end", 58);
        ParsingTable.addReduceTable(115, "break", 58);
        ParsingTable.addReduceTable(115, "if", 58);
        ParsingTable.addReduceTable(115, "int", 58);
        ParsingTable.addReduceTable(115, "integer", 58);
        ParsingTable.addReduceTable(115, "print_line", 58);
        ParsingTable.addReduceTable(115, "display", 58);
        ParsingTable.addReduceTable(115, "for", 58);
        ParsingTable.addReduceTable(115, "while", 58);
        ParsingTable.addReduceTable(116, ")", 30);
        ParsingTable.addReduceTable(117, ")", 39);
        ParsingTable.addReduceTable(118, ")", 40);
        ParsingTable.addReduceTable(119, ")", 43);
        ParsingTable.addReduceTable(120, ")", 2);
        ParsingTable.addReduceTable(121, "Identifier", 22);
        ParsingTable.addReduceTable(121, "end", 22);
        ParsingTable.addReduceTable(121, "break", 22);
        ParsingTable.addReduceTable(121, "if", 22);
        ParsingTable.addReduceTable(121, "else_if", 22);
        ParsingTable.addReduceTable(121, "else", 22);
        ParsingTable.addReduceTable(121, "int", 22);
        ParsingTable.addReduceTable(121, "integer", 22);
        ParsingTable.addReduceTable(121, "print_line", 22);
        ParsingTable.addReduceTable(121, "display", 22);
        ParsingTable.addReduceTable(121, "for", 22);
        ParsingTable.addReduceTable(121, "while", 22);
        ParsingTable.addReduceTable(122, "Identifier", 29);
        ParsingTable.addShiftTable(122, "if", 20);
        ParsingTable.addShiftTable(122, "int", 21);
        ParsingTable.addShiftTable(122, "integer", 22);
        ParsingTable.addShiftTable(122, "print_line", 16);
        ParsingTable.addShiftTable(122, "display", 17);
        ParsingTable.addShiftTable(122, "for", 18);
        ParsingTable.addShiftTable(122, "while", 19);
        ParsingTable.addReduceTable(123, "Identifier", 25);
        ParsingTable.addReduceTable(123, "end", 25);
        ParsingTable.addReduceTable(123, "break", 25);
        ParsingTable.addReduceTable(123, "if", 25);
        ParsingTable.addShiftTable(123, "else_if", 39);
        ParsingTable.addReduceTable(123, "else", 25);
        ParsingTable.addReduceTable(123, "int", 25);
        ParsingTable.addReduceTable(123, "integer", 25);
        ParsingTable.addReduceTable(123, "print_line", 25);
        ParsingTable.addReduceTable(123, "display", 25);
        ParsingTable.addReduceTable(123, "for", 25);
        ParsingTable.addReduceTable(123, "while", 25);
        ParsingTable.addReduceTable(124, ";", 34);
        ParsingTable.addShiftTable(124, ",", 78);
        ParsingTable.addShiftTable(125, "=", 62);
        ParsingTable.addReduceTable(125, ";", 138);
        ParsingTable.addReduceTable(126, ";", 38);
        ParsingTable.addReduceTable(126, ",", 38);
        ParsingTable.addShiftTable(126, "+", 106);
        ParsingTable.addShiftTable(126, "-", 107);
        ParsingTable.addShiftTable(126, "/", 108);
        ParsingTable.addShiftTable(126, "*", 109);
        ParsingTable.addReduceTable(127, ")", 55);
        ParsingTable.addShiftTable(127, "++", 141);
        ParsingTable.addReduceTable(128, "Identifier", 2);
        ParsingTable.addReduceTable(128, "end", 2);
        ParsingTable.addReduceTable(128, "break", 2);
        ParsingTable.addReduceTable(128, "if", 2);
        ParsingTable.addReduceTable(128, ")", 2);
        ParsingTable.addReduceTable(128, "int", 2);
        ParsingTable.addReduceTable(128, "integer", 2);
        ParsingTable.addReduceTable(128, "print_line", 2);
        ParsingTable.addReduceTable(128, "++", 2);
        ParsingTable.addReduceTable(128, "display", 2);
        ParsingTable.addReduceTable(128, "for", 2);
        ParsingTable.addReduceTable(128, "while", 2);
        ParsingTable.addReduceTable(129, ";", 30);
        ParsingTable.addReduceTable(130, ";", 39);
        ParsingTable.addReduceTable(131, ";", 40);
        ParsingTable.addReduceTable(132, ";", 43);
        ParsingTable.addReduceTable(133, ";", 2);
        ParsingTable.addShiftTable(134, "end", 142);
        ParsingTable.addReduceTable(135, "Identifier", 23);
        ParsingTable.addReduceTable(135, "end", 23);
        ParsingTable.addReduceTable(135, "break", 23);
        ParsingTable.addReduceTable(135, "if", 23);
        ParsingTable.addReduceTable(135, "else", 23);
        ParsingTable.addReduceTable(135, "int", 23);
        ParsingTable.addReduceTable(135, "integer", 23);
        ParsingTable.addReduceTable(135, "print_line", 23);
        ParsingTable.addReduceTable(135, "display", 23);
        ParsingTable.addReduceTable(135, "for", 23);
        ParsingTable.addReduceTable(135, "while", 23);
        ParsingTable.addReduceTable(136, "Identifier", 24);
        ParsingTable.addReduceTable(136, "end", 24);
        ParsingTable.addReduceTable(136, "break", 24);
        ParsingTable.addReduceTable(136, "if", 24);
        ParsingTable.addReduceTable(136, "else", 24);
        ParsingTable.addReduceTable(136, "int", 24);
        ParsingTable.addReduceTable(136, "integer", 24);
        ParsingTable.addReduceTable(136, "print_line", 24);
        ParsingTable.addReduceTable(136, "display", 24);
        ParsingTable.addReduceTable(136, "for", 24);
        ParsingTable.addReduceTable(136, "while", 24);
        ParsingTable.addReduceTable(137, ";", 33);
        ParsingTable.addReduceTable(138, ";", 34);
        ParsingTable.addShiftTable(138, ",", 103);
        ParsingTable.addReduceTable(139, ";", 37);
        ParsingTable.addReduceTable(139, ",", 37);
        ParsingTable.addShiftTable(140, ")", 144);
        ParsingTable.addReduceTable(141, ")", 54);
        ParsingTable.addReduceTable(142, "Identifier", 3);
        ParsingTable.addReduceTable(142, "end", 3);
        ParsingTable.addReduceTable(142, "break", 3);
        ParsingTable.addReduceTable(142, "if", 3);
        ParsingTable.addReduceTable(142, "else_if", 3);
        ParsingTable.addReduceTable(142, "else", 3);
        ParsingTable.addReduceTable(142, "int", 3);
        ParsingTable.addReduceTable(142, "integer", 3);
        ParsingTable.addReduceTable(142, "print_line", 3);
        ParsingTable.addReduceTable(142, "display", 3);
        ParsingTable.addReduceTable(142, "for", 3);
        ParsingTable.addReduceTable(142, "while", 3);
        ParsingTable.addReduceTable(143, ";", 33);
        ParsingTable.addReduceTable(143, ",", 33);
        ParsingTable.addShiftTable(144, "begin", 59);
        ParsingTable.addReduceTable(145, "Identifier", 57);
        ParsingTable.addReduceTable(145, "end", 57);
        ParsingTable.addReduceTable(145, "break", 57);
        ParsingTable.addReduceTable(145, "if", 57);
        ParsingTable.addReduceTable(145, "int", 57);
        ParsingTable.addReduceTable(145, "integer", 57);
        ParsingTable.addReduceTable(145, "print_line", 57);
        ParsingTable.addReduceTable(145, "display", 57);
        ParsingTable.addReduceTable(145, "for", 57);
        ParsingTable.addReduceTable(145, "while", 57);


        ParsingTable.addGotoTable(0, "PROGRAM", 1);
        ParsingTable.addGotoTable(2, "IDENTIFIER", 3);
        ParsingTable.addGotoTable(3, "BLOCK", 5);
        ParsingTable.addGotoTable(6, "STATEMENT", 7);
        ParsingTable.addGotoTable(6, "IF_BLOCK", 8);
        ParsingTable.addGotoTable(6, "IF_STMT", 14);
        ParsingTable.addGotoTable(6, "TYPE", 15);
        ParsingTable.addGotoTable(6, "ASSIGNMENT", 9);
        ParsingTable.addGotoTable(6, "PRINT", 10);
        ParsingTable.addGotoTable(6, "DISPLAY", 11);
        ParsingTable.addGotoTable(6, "FOR_STMT", 12);
        ParsingTable.addGotoTable(6, "WHILE_STMT", 13);
        ParsingTable.addGotoTable(8, "STMT", 24);
        ParsingTable.addGotoTable(8, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(8, "IF_STMT", 14);
        ParsingTable.addGotoTable(8, "TYPE", 15);
        ParsingTable.addGotoTable(8, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(8, "PRINT", 27);
        ParsingTable.addGotoTable(8, "DISPLAY", 28);
        ParsingTable.addGotoTable(8, "FOR_STMT", 29);
        ParsingTable.addGotoTable(8, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(9, "STMT", 32);
        ParsingTable.addGotoTable(9, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(9, "IF_STMT", 14);
        ParsingTable.addGotoTable(9, "TYPE", 15);
        ParsingTable.addGotoTable(9, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(9, "PRINT", 27);
        ParsingTable.addGotoTable(9, "DISPLAY", 28);
        ParsingTable.addGotoTable(9, "FOR_STMT", 29);
        ParsingTable.addGotoTable(9, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(10, "STMT", 33);
        ParsingTable.addGotoTable(10, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(10, "IF_STMT", 14);
        ParsingTable.addGotoTable(10, "TYPE", 15);
        ParsingTable.addGotoTable(10, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(10, "PRINT", 27);
        ParsingTable.addGotoTable(10, "DISPLAY", 28);
        ParsingTable.addGotoTable(10, "FOR_STMT", 29);
        ParsingTable.addGotoTable(10, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(11, "STMT", 34);
        ParsingTable.addGotoTable(11, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(11, "IF_STMT", 14);
        ParsingTable.addGotoTable(11, "TYPE", 15);
        ParsingTable.addGotoTable(11, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(11, "PRINT", 27);
        ParsingTable.addGotoTable(11, "DISPLAY", 28);
        ParsingTable.addGotoTable(11, "FOR_STMT", 29);
        ParsingTable.addGotoTable(11, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(12, "STMT", 35);
        ParsingTable.addGotoTable(12, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(12, "IF_STMT", 14);
        ParsingTable.addGotoTable(12, "TYPE", 15);
        ParsingTable.addGotoTable(12, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(12, "PRINT", 27);
        ParsingTable.addGotoTable(12, "DISPLAY", 28);
        ParsingTable.addGotoTable(12, "FOR_STMT", 29);
        ParsingTable.addGotoTable(12, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(13, "STMT", 36);
        ParsingTable.addGotoTable(13, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(13, "IF_STMT", 14);
        ParsingTable.addGotoTable(13, "TYPE", 15);
        ParsingTable.addGotoTable(13, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(13, "PRINT", 27);
        ParsingTable.addGotoTable(13, "DISPLAY", 28);
        ParsingTable.addGotoTable(13, "FOR_STMT", 29);
        ParsingTable.addGotoTable(13, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(14, "ELSE_IF_STMT", 37);
        ParsingTable.addGotoTable(14, "ELSE_STMT", 38);
        ParsingTable.addGotoTable(15, "IDENTIFIER", 42);
        ParsingTable.addGotoTable(15, "ASSIGN", 41);
        ParsingTable.addGotoTable(25, "STMT", 49);
        ParsingTable.addGotoTable(25, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(25, "IF_STMT", 14);
        ParsingTable.addGotoTable(25, "TYPE", 15);
        ParsingTable.addGotoTable(25, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(25, "PRINT", 27);
        ParsingTable.addGotoTable(25, "DISPLAY", 28);
        ParsingTable.addGotoTable(25, "FOR_STMT", 29);
        ParsingTable.addGotoTable(25, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(26, "STMT", 50);
        ParsingTable.addGotoTable(26, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(26, "IF_STMT", 14);
        ParsingTable.addGotoTable(26, "TYPE", 15);
        ParsingTable.addGotoTable(26, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(26, "PRINT", 27);
        ParsingTable.addGotoTable(26, "DISPLAY", 28);
        ParsingTable.addGotoTable(26, "FOR_STMT", 29);
        ParsingTable.addGotoTable(26, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(27, "STMT", 51);
        ParsingTable.addGotoTable(27, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(27, "IF_STMT", 14);
        ParsingTable.addGotoTable(27, "TYPE", 15);
        ParsingTable.addGotoTable(27, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(27, "PRINT", 27);
        ParsingTable.addGotoTable(27, "DISPLAY", 28);
        ParsingTable.addGotoTable(27, "FOR_STMT", 29);
        ParsingTable.addGotoTable(27, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(28, "STMT", 52);
        ParsingTable.addGotoTable(28, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(28, "IF_STMT", 14);
        ParsingTable.addGotoTable(28, "TYPE", 15);
        ParsingTable.addGotoTable(28, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(28, "PRINT", 27);
        ParsingTable.addGotoTable(28, "DISPLAY", 28);
        ParsingTable.addGotoTable(28, "FOR_STMT", 29);
        ParsingTable.addGotoTable(28, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(29, "STMT", 53);
        ParsingTable.addGotoTable(29, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(29, "IF_STMT", 14);
        ParsingTable.addGotoTable(29, "TYPE", 15);
        ParsingTable.addGotoTable(29, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(29, "PRINT", 27);
        ParsingTable.addGotoTable(29, "DISPLAY", 28);
        ParsingTable.addGotoTable(29, "FOR_STMT", 29);
        ParsingTable.addGotoTable(29, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(30, "STMT", 54);
        ParsingTable.addGotoTable(30, "IF_BLOCK", 25);
        ParsingTable.addGotoTable(30, "IF_STMT", 14);
        ParsingTable.addGotoTable(30, "TYPE", 15);
        ParsingTable.addGotoTable(30, "ASSIGNMENT", 26);
        ParsingTable.addGotoTable(30, "PRINT", 27);
        ParsingTable.addGotoTable(30, "DISPLAY", 28);
        ParsingTable.addGotoTable(30, "FOR_STMT", 29);
        ParsingTable.addGotoTable(30, "WHILE_STMT", 30);
        ParsingTable.addGotoTable(37, "ELSE_STMT", 56);
        ParsingTable.addGotoTable(40, "BLOCK", 58);
        ParsingTable.addGotoTable(42, "EQUAL", 61);
        ParsingTable.addGotoTable(44, "STRING", 63);

        // Yo
        ParsingTable.addGotoTable(44, "IDENTIFIER", 63);
        
        ParsingTable.addGotoTable(46, "TYPE", 67);
        ParsingTable.addGotoTable(46, "ASSIGNMENT", 66);
        ParsingTable.addGotoTable(47, "IDENTIFIER", 71);
        ParsingTable.addGotoTable(47, "COMPARISON_STMT", 68);
        ParsingTable.addGotoTable(47, "NUMORID", 69);
        ParsingTable.addGotoTable(47, "NUMBER", 70);
        ParsingTable.addGotoTable(48, "IDENTIFIER", 71);
        ParsingTable.addGotoTable(48, "COMPARISON_STMT", 74);
        ParsingTable.addGotoTable(48, "NUMORID", 69);
        ParsingTable.addGotoTable(48, "NUMBER", 70);
        ParsingTable.addGotoTable(57, "IDENTIFIER", 71);
        ParsingTable.addGotoTable(57, "COMPARISON_STMT", 75);
        ParsingTable.addGotoTable(57, "NUMORID", 69);
        ParsingTable.addGotoTable(57, "NUMBER", 70);
        ParsingTable.addGotoTable(59, "STATEMENT", 76);
        ParsingTable.addGotoTable(59, "IF_BLOCK", 8);
        ParsingTable.addGotoTable(59, "IF_STMT", 14);
        ParsingTable.addGotoTable(59, "TYPE", 15);
        ParsingTable.addGotoTable(59, "ASSIGNMENT", 9);
        ParsingTable.addGotoTable(59, "PRINT", 10);
        ParsingTable.addGotoTable(59, "DISPLAY", 11);
        ParsingTable.addGotoTable(59, "FOR_STMT", 12);
        ParsingTable.addGotoTable(59, "WHILE_STMT", 13);
        ParsingTable.addGotoTable(61, "ASSIGN'", 77);
        ParsingTable.addGotoTable(62, "IDENTIFIER", 82);
        ParsingTable.addGotoTable(62, "ASSIGNED", 79);
        ParsingTable.addGotoTable(62, "NUMORID", 80);
        ParsingTable.addGotoTable(62, "NUMBER", 81);
        ParsingTable.addGotoTable(66, "IDENTIFIER", 71);
        ParsingTable.addGotoTable(66, "COMPARISON_STMT", 87);
        ParsingTable.addGotoTable(66, "NUMORID", 88);
        ParsingTable.addGotoTable(66, "NUMBER", 70);
        ParsingTable.addGotoTable(67, "IDENTIFIER", 42);
        ParsingTable.addGotoTable(67, "ASSIGN", 89);
        ParsingTable.addGotoTable(69, "COMPARISON_OP", 91);
        ParsingTable.addGotoTable(78, "IDENTIFIER", 101);
        ParsingTable.addGotoTable(79, "ASSIGN'", 102);
        ParsingTable.addGotoTable(80, "ASSIGNED'", 104);
        ParsingTable.addGotoTable(80, "ARITHOP", 105);
        ParsingTable.addGotoTable(88, "COMPARISON_OP", 113);
        ParsingTable.addGotoTable(90, "BLOCK", 115);
        ParsingTable.addGotoTable(91, "IDENTIFIER", 118);
        ParsingTable.addGotoTable(91, "NUMORID", 116);
        ParsingTable.addGotoTable(91, "NUMBER", 117);
        ParsingTable.addGotoTable(98, "BLOCK", 121);
        ParsingTable.addGotoTable(99, "BLOCK", 123);
        ParsingTable.addGotoTable(101, "EQUAL", 124);
        ParsingTable.addGotoTable(103, "IDENTIFIER", 125);
        ParsingTable.addGotoTable(105, "IDENTIFIER", 82);
        ParsingTable.addGotoTable(105, "NUMORID", 126);
        ParsingTable.addGotoTable(105, "NUMBER", 81);
        ParsingTable.addGotoTable(112, "IDENTIFIER", 127);
        ParsingTable.addGotoTable(113, "IDENTIFIER", 131);
        ParsingTable.addGotoTable(113, "NUMORID", 129);
        ParsingTable.addGotoTable(113, "NUMBER", 130);
        ParsingTable.addGotoTable(122, "STATEMENT", 134);
        ParsingTable.addGotoTable(122, "IF_BLOCK", 8);
        ParsingTable.addGotoTable(122, "IF_STMT", 14);
        ParsingTable.addGotoTable(122, "TYPE", 15);
        ParsingTable.addGotoTable(122, "ASSIGNMENT", 9);
        ParsingTable.addGotoTable(122, "PRINT", 10);
        ParsingTable.addGotoTable(122, "DISPLAY", 11);
        ParsingTable.addGotoTable(122, "FOR_STMT", 12);
        ParsingTable.addGotoTable(122, "WHILE_STMT", 13);
        ParsingTable.addGotoTable(123, "ELSE_IF_STMT", 136);
        ParsingTable.addGotoTable(123, "NEW_ELSE_IF", 135);
        ParsingTable.addGotoTable(124, "ASSIGN'", 137);
        ParsingTable.addGotoTable(125, "EQUAL", 138);
        ParsingTable.addGotoTable(126, "ASSIGNED'", 139);
        ParsingTable.addGotoTable(126, "ARITHOP", 105);
        ParsingTable.addGotoTable(127, "INCREMENTALOP", 140);
        ParsingTable.addGotoTable(138, "ASSIGN'", 143);
        ParsingTable.addGotoTable(144, "BLOCK", 145);

    }

    public void run(SmallLexer smallLexer) {

        int currentState = 0;
        int nextState = 0; 

        stack.push(String.valueOf(currentState));

        String token = "";
        String type = "";

        String reducedNonterminal;

        smallLexer.getTokensList().add("$");
        smallLexer.getTypesList().add("");

        for (int i = 0 ; i < smallLexer.getTokensList().size() ; i++) {

            currentState = Integer.parseInt(stack.peek());

            if (currentState == -1) break;
           
            type = smallLexer.getTypesUsingIndex(i);
            token = smallLexer.getTokensUsingIndex(i);


            if (token == "$" && currentState == 1) {
                System.out.println("Accept");
                return;
            }

            if (type.equals("Identifier") || type.equals("Number Literal") || type.equals("String Literal")) {
                nextState = ParsingTable.getShiftNextToken(currentState, type);
            } else {
                nextState = ParsingTable.getShiftNextToken(currentState, token);
            }

            
            if (nextState == -1) {

                if (type.equals("Identifier") || type.equals("Number Literal") || type.equals("String Literal")) {
                    nextState = ParsingTable.getReduceToken(currentState, type);
                } else {
                    nextState = ParsingTable.getReduceToken(currentState, token);
                }
                
                reducedNonterminal = reduce(nextState);
                currentState = Integer.parseInt(stack.peek());

                stack.push(reducedNonterminal);
                nextState = ParsingTable.getGotoTableToken(currentState, reducedNonterminal);
                stack.push(String.valueOf(nextState));

                System.out.println(stack);

                if (nextState == -1) {
                    System.out.println("Parsing error");
                }
   
                i--;
                continue;
            }

            stack.push(smallLexer.getTokensUsingIndex(i));
            
            stack.push(String.valueOf(nextState));
            System.out.println(stack);
            
        }

    }

    public String reduce(int state) {

        if (state == 1) {

            for (int i = 0 ; i < 6 ; i++) {

                stack.pop();

            }

            return "PROGRAM";
        }

        if (state == 2) {

            stack.pop();
            stack.pop();

            return "IDENTIFIER";

        } 

        if (state == 3) {


            for (int i = 0 ; i < 6 ; i++) {
                stack.pop();
            }

            return "BLOCK";
        }

        if (state == 5) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STATEMENT";

        }

        if (state == 6) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STATEMENT";
        }

        if (state == 7) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STATEMENT";
        }

        if (state == 8) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STATEMENT";
        }

        if (state == 10) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STMT";

        }
        
        if (state == 11) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STMT";

        }

        if (state == 12) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STMT";

        }

        
        if (state == 13) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STMT";

        }

        if (state == 14) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STMT";

        }

        
        if (state == 15) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STMT";

        }

        if (state == 16) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "STMT";

        }

        if (state == 17) {


            return "STMT";
        }

        if (state == 18) {

            stack.pop();
            stack.pop();

            return "IF_BLOCK";
        }

        if (state == 21) {
            for(int i = 0 ; i < 6 ; i++) {
                stack.pop();
            }

            return "IF_BLOCK";
        }

        if (state == 22) {

            for (int i = 0 ; i < 10 ; i++) {
                stack.pop();
            }

            return "IF_STMT";
        }

        if (state == 23) {

            for (int i = 0 ; i < 12 ; i++) {
                stack.pop();
            }

            return "ELSE_IF_STMT";
        }



        if (state == 25) {

            return "NEW_ELSE_IF";

        }

        if (state == 26) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "ELSE_STMT";

        }


        if (state == 27) {

            stack.pop();
            stack.pop();

            return "TYPE";
        }

        if (state == 28) {

            stack.pop();
            stack.pop();

            return "TYPE";
        }

        if (state == 29) {

            return "TYPE";

        }

        if (state == 30) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "COMPARISON_STMT";
        }

        if (state == 31) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "ASSIGNMENT";

        }

        if (state == 32) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "ASSIGN";

        }

        if (state == 33) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "ASSIGN'";

        }

        if (state == 34) {
            return "ASSIGN'";
        }

        if (state == 35) {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            

            return "EQUAL";
        }
        

        if (state == 36) {

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

            return "ASSIGNED";

        }

        if (state == 37) {

            for (int i = 0 ; i < 6 ; i++) {
                stack.pop();
            }

            return "ASSIGNED'";

        }

        if (state == 38) {

            return "ASSIGNED'";

        }

        if (state == 39) {

            stack.pop();
            stack.pop();

            return "NUMORID";
        }

        if (state == 40) {

            stack.pop();
            stack.pop();

            return "NUMORID";

        }

        if (state == 41) {

            for (int i = 0 ; i < 10 ; i++) {
                stack.pop();
            }

            return "PRINT";
        }

        if (state == 42) {

            stack.pop();
            stack.pop();

            return "STRING";

        }

        if (state == 43) {

            stack.pop();
            stack.pop();

            return "NUMBER";
        }

        if (state == 45) {

            stack.pop();
            stack.pop();

            return "COMPARISON_OP";

        }

        if (state == 46) {

            stack.pop();
            stack.pop();

            return "COMPARISON_OP";

        }

        if (state == 50) {

            stack.pop();
            stack.pop();

            return "ARITHOP";

        }

        if (state == 53) {

            stack.pop();
            stack.pop();

            return "ARITHOP";

        }

        
        if (state == 54) {

            stack.pop();
            stack.pop();

            return "INCREMENTALOP";

        }

        if (state == 56) {

            for (int i = 0 ; i < 10 ; i++) {
                stack.pop();
            }

            return "DISPLAY";

        }

        if (state == 57) {

            for (int i = 0 ; i < 18 ; i++) {
                stack.pop();
            }

            return "FOR_STMT";

        }

        if (state == 58) {

            for (int i = 0 ; i < 10 ; i++) 
                stack.pop();

            return "WHILE_STMT";
        }   

        if (state == 60) {

            for (int i = 0 ; i < 6 ; i++) {
                stack.pop();
            }

            return "ASSIGNMENT";
            
        }



        if (state == 138) {

            return "EQUAL";

        }

        
        System.out.println("Undefiend");
        return null;
    }


}
