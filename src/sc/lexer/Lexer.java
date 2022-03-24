/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.lexer;

import java.io.*;
import sc.node.*;

@SuppressWarnings("nls")
public class Lexer
{
    protected Token token;
    protected State state = State.INITIAL;

    private IPushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    @SuppressWarnings("unused")
    protected void filter() throws LexerException, IOException
    {
        // Do nothing
    }

    public Lexer(@SuppressWarnings("hiding") final PushbackReader in)
    {
        this.in = new IPushbackReader() {

            private PushbackReader pushbackReader = in;
            
            @Override
            public void unread(int c) throws IOException {
                pushbackReader.unread(c);
            }
            
            @Override
            public int read() throws IOException {
                return pushbackReader.read();
            }
        };
    }
 
    public Lexer(@SuppressWarnings("hiding") IPushbackReader in)
    {
        this.in = in;
    }
 
    public Token peek() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        return this.token;
    }

    public Token next() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        Token result = this.token;
        this.token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = this.pos;
        int start_line = this.line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        @SuppressWarnings("hiding") int[][][] gotoTable = Lexer.gotoTable[this.state.id()];
        @SuppressWarnings("hiding") int[] accept = Lexer.accept[this.state.id()];
        this.text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(this.cr)
                    {
                        this.cr = false;
                    }
                    else
                    {
                        this.line++;
                        this.pos = 0;
                    }
                    break;
                case 13:
                    this.line++;
                    this.pos = 0;
                    this.cr = true;
                    break;
                default:
                    this.pos++;
                    this.cr = false;
                    break;
                }

                this.text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        // int middle = (low + high) / 2;
                        int middle = (low + high) >>> 1;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = this.text.length();
                    accept_pos = this.pos;
                    accept_line = this.line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            @SuppressWarnings("hiding") Token token = new0(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 1:
                        {
                            @SuppressWarnings("hiding") Token token = new1(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 2:
                        {
                            @SuppressWarnings("hiding") Token token = new2(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 3:
                        {
                            @SuppressWarnings("hiding") Token token = new3(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 4:
                        {
                            @SuppressWarnings("hiding") Token token = new4(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 5:
                        {
                            @SuppressWarnings("hiding") Token token = new5(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 6:
                        {
                            @SuppressWarnings("hiding") Token token = new6(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 7:
                        {
                            @SuppressWarnings("hiding") Token token = new7(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 8:
                        {
                            @SuppressWarnings("hiding") Token token = new8(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 9:
                        {
                            @SuppressWarnings("hiding") Token token = new9(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 10:
                        {
                            @SuppressWarnings("hiding") Token token = new10(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 11:
                        {
                            @SuppressWarnings("hiding") Token token = new11(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 12:
                        {
                            @SuppressWarnings("hiding") Token token = new12(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 13:
                        {
                            @SuppressWarnings("hiding") Token token = new13(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 14:
                        {
                            @SuppressWarnings("hiding") Token token = new14(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 15:
                        {
                            @SuppressWarnings("hiding") Token token = new15(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 16:
                        {
                            @SuppressWarnings("hiding") Token token = new16(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 17:
                        {
                            @SuppressWarnings("hiding") Token token = new17(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 18:
                        {
                            @SuppressWarnings("hiding") Token token = new18(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 19:
                        {
                            @SuppressWarnings("hiding") Token token = new19(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 20:
                        {
                            @SuppressWarnings("hiding") Token token = new20(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 21:
                        {
                            @SuppressWarnings("hiding") Token token = new21(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 22:
                        {
                            @SuppressWarnings("hiding") Token token = new22(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 23:
                        {
                            @SuppressWarnings("hiding") Token token = new23(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 24:
                        {
                            @SuppressWarnings("hiding") Token token = new24(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 25:
                        {
                            @SuppressWarnings("hiding") Token token = new25(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 26:
                        {
                            @SuppressWarnings("hiding") Token token = new26(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 27:
                        {
                            @SuppressWarnings("hiding") Token token = new27(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 28:
                        {
                            @SuppressWarnings("hiding") Token token = new28(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 29:
                        {
                            @SuppressWarnings("hiding") Token token = new29(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    }
                }
                else
                {
                    if(this.text.length() > 0)
                    {
                        throw new LexerException(
                            new InvalidToken(this.text.substring(0, 1), start_line + 1, start_pos + 1),
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + this.text);
                    }

                    @SuppressWarnings("hiding") EOF token = new EOF(
                        start_line + 1,
                        start_pos + 1);
                    return token;
                }
            }
        }
    }

    Token new0(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TEspaces(text, line, pos); }
    Token new1(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TCommentaire(text, line, pos); }
    Token new2(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TVirgule(line, pos); }
    Token new3(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDivise(line, pos); }
    Token new4(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPointVirgule(line, pos); }
    Token new5(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TMult(line, pos); }
    Token new6(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TMinus(line, pos); }
    Token new7(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TParentheseOuvrante(line, pos); }
    Token new8(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TParentheseFermante(line, pos); }
    Token new9(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TCrochetOuvrant(line, pos); }
    Token new10(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TCrochetFermant(line, pos); }
    Token new11(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TAccoladeOuvrante(line, pos); }
    Token new12(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TAccoladeFermante(line, pos); }
    Token new13(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TEgale(line, pos); }
    Token new14(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TInferieur(line, pos); }
    Token new15(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TEt(line, pos); }
    Token new16(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TOu(line, pos); }
    Token new17(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNon(line, pos); }
    Token new18(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPlus(line, pos); }
    Token new19(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TSi(line, pos); }
    Token new20(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TAlors(line, pos); }
    Token new21(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TSinon(line, pos); }
    Token new22(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TTantque(line, pos); }
    Token new23(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TFaire(line, pos); }
    Token new24(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TType(line, pos); }
    Token new25(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TRetour(line, pos); }
    Token new26(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLire(line, pos); }
    Token new27(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TEcrire(line, pos); }
    Token new28(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNombre(text, line, pos); }
    Token new29(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TIdentif(text, line, pos); }

    private int getChar() throws IOException
    {
        if(this.eof)
        {
            return -1;
        }

        int result = this.in.read();

        if(result == -1)
        {
            this.eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = this.text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            this.eof = false;

            this.in.unread(this.text.charAt(i));
        }
    }

    protected void unread(@SuppressWarnings("hiding") Token token) throws IOException
    {
        @SuppressWarnings("hiding") String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            this.eof = false;

            this.in.unread(text.charAt(i));
        }

        this.pos = token.getPos() - 1;
        this.line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(this.text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INITIAL
            {{10, 10, 1}, {13, 13, 2}, {32, 32, 3}, {33, 33, 4}, {35, 35, 5}, {36, 36, 6}, {38, 38, 7}, {40, 40, 8}, {41, 41, 9}, {42, 42, 10}, {43, 43, 11}, {44, 44, 12}, {45, 45, 13}, {47, 47, 14}, {48, 57, 15}, {59, 59, 16}, {60, 60, 17}, {61, 61, 18}, {65, 90, 6}, {91, 91, 19}, {93, 93, 20}, {95, 95, 6}, {97, 97, 21}, {98, 100, 6}, {101, 101, 22}, {102, 102, 23}, {103, 107, 6}, {108, 108, 24}, {109, 113, 6}, {114, 114, 25}, {115, 115, 26}, {116, 116, 27}, {117, 122, 6}, {123, 123, 28}, {124, 124, 29}, {125, 125, 30}, },
            {{10, 32, -2}, },
            {{10, 32, -2}, },
            {{10, 32, -2}, },
            {},
            {{0, 9, 31}, {10, 10, 32}, {11, 12, 31}, {13, 13, 33}, {14, 65535, 31}, },
            {{48, 57, 34}, {65, 90, 34}, {97, 122, 34}, },
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {{48, 57, 15}, },
            {},
            {},
            {},
            {},
            {},
            {{48, 90, -8}, {97, 107, 34}, {108, 108, 35}, {109, 122, 34}, },
            {{48, 90, -8}, {97, 98, 34}, {99, 99, 36}, {100, 109, 34}, {110, 110, 37}, {111, 122, 34}, },
            {{48, 90, -8}, {97, 97, 38}, {98, 122, 34}, },
            {{48, 90, -8}, {97, 104, 34}, {105, 105, 39}, {106, 122, 34}, },
            {{48, 90, -8}, {97, 100, 34}, {101, 101, 40}, {102, 122, 34}, },
            {{48, 104, -26}, {105, 105, 41}, {106, 122, 34}, },
            {{48, 90, -8}, {97, 97, 42}, {98, 122, 34}, },
            {},
            {},
            {},
            {{0, 65535, -7}, },
            {{13, 13, 43}, },
            {},
            {{48, 122, -8}, },
            {{48, 90, -8}, {97, 110, 34}, {111, 111, 44}, {112, 122, 34}, },
            {{48, 90, -8}, {97, 113, 34}, {114, 114, 45}, {115, 122, 34}, },
            {{48, 90, -8}, {97, 115, 34}, {116, 116, 46}, {117, 122, 34}, },
            {{48, 104, -26}, {105, 105, 47}, {106, 122, 34}, },
            {{48, 113, -38}, {114, 114, 48}, {115, 122, 34}, },
            {{48, 115, -39}, {116, 116, 49}, {117, 122, 34}, },
            {{48, 90, -8}, {97, 109, 34}, {110, 110, 50}, {111, 122, 34}, },
            {{48, 109, -43}, {110, 110, 51}, {111, 122, 34}, },
            {},
            {{48, 113, -38}, {114, 114, 52}, {115, 122, 34}, },
            {{48, 104, -26}, {105, 105, 53}, {106, 122, 34}, },
            {{48, 104, -26}, {105, 105, 54}, {106, 122, 34}, },
            {{48, 113, -38}, {114, 114, 55}, {115, 122, 34}, },
            {{48, 100, -27}, {101, 101, 56}, {102, 122, 34}, },
            {{48, 110, -37}, {111, 111, 57}, {112, 122, 34}, },
            {{48, 110, -37}, {111, 111, 58}, {112, 122, 34}, },
            {{48, 115, -39}, {116, 116, 59}, {117, 122, 34}, },
            {{48, 90, -8}, {97, 114, 34}, {115, 115, 60}, {116, 122, 34}, },
            {{48, 113, -38}, {114, 114, 61}, {115, 122, 34}, },
            {{48, 100, -27}, {101, 101, 62}, {102, 122, 34}, },
            {{48, 100, -27}, {101, 101, 63}, {102, 122, 34}, },
            {{48, 122, -8}, },
            {{48, 90, -8}, {97, 116, 34}, {117, 117, 64}, {118, 122, 34}, },
            {{48, 109, -43}, {110, 110, 65}, {111, 122, 34}, },
            {{48, 90, -8}, {97, 112, 34}, {113, 113, 66}, {114, 122, 34}, },
            {{48, 122, -8}, },
            {{48, 100, -27}, {101, 101, 67}, {102, 122, 34}, },
            {{48, 113, -38}, {114, 114, 68}, {115, 122, 34}, },
            {{48, 122, -8}, },
            {{48, 113, -38}, {114, 114, 69}, {115, 122, 34}, },
            {{48, 122, -8}, },
            {{48, 116, -59}, {117, 117, 70}, {118, 122, 34}, },
            {{48, 122, -8}, },
            {{48, 122, -8}, },
            {{48, 122, -8}, },
            {{48, 100, -27}, {101, 101, 71}, {102, 122, 34}, },
            {{48, 122, -8}, },
        }
    };*/

    private static int[][] accept;
/*  {
        // INITIAL
        {-1, 0, 0, 0, 17, -1, 29, 15, 7, 8, 5, 18, 2, 6, 3, 28, 4, 14, 13, 9, 10, 29, 29, 29, 29, 29, 29, 29, 11, 16, 12, -1, 1, 1, 29, 29, 29, 29, 29, 29, 29, 19, 29, 1, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 26, 29, 29, 29, 20, 29, 29, 23, 29, 21, 29, 27, 24, 25, 29, 22, },

    };*/

    public static class State
    {
        public final static State INITIAL = new State(0);

        private int id;

        private State(@SuppressWarnings("hiding") int id)
        {
            this.id = id;
        }

        public int id()
        {
            return this.id;
        }
    }

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Lexer.class.getResourceAsStream("lexer.dat")));

            // read gotoTable
            int length = s.readInt();
            gotoTable = new int[length][][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][][];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                    length = s.readInt();
                    gotoTable[i][j] = new int[length][3];
                    for(int k = 0; k < gotoTable[i][j].length; k++)
                    {
                        for(int l = 0; l < 3; l++)
                        {
                            gotoTable[i][j][k][l] = s.readInt();
                        }
                    }
                }
            }

            // read accept
            length = s.readInt();
            accept = new int[length][];
            for(int i = 0; i < accept.length; i++)
            {
                length = s.readInt();
                accept[i] = new int[length];
                for(int j = 0; j < accept[i].length; j++)
                {
                    accept[i][j] = s.readInt();
                }
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
        }
    }
}
