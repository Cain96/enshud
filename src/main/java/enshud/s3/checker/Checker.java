package enshud.s3.checker;

import enshud.s3.checker.Helper.FileRead;

public class Checker {
    /**
     * サンプルmainメソッド．
     * 単体テストの対象ではないので自由に改変しても良い．
     */
    public static void main(final String[] args) {
        // normalの確認
        new Checker().run("data/ts/normal05.ts");
        //new Checker().run("data/ts/normal05.ts");

        // synerrの確認
        //new Checker().run("data/ts/synerr01.ts");
        //new Checker().run("data/ts/synerr02.ts");

        // semerrの確認
        //new Checker().run("data/ts/semerr01.ts");
        //new Checker().run("data/ts/semerr06.ts");
    }

    /**
     * TODO
     * <p>
     * 開発対象となるChecker実行メソッド．
     * 以下の仕様を満たすこと．
     * <p>
     * 仕様:
     * 第一引数で指定されたtsファイルを読み込み，意味解析を行う．
     * 意味的に正しい場合は標準出力に"OK"を，正しくない場合は"Sematic error: line"という文字列とともに，
     * 最初のエラーを見つけた行の番号を標準エラーに出力すること （例: "Semantic error: line 6"）．
     * また，構文的なエラーが含まれる場合もエラーメッセージを表示すること（例： "Syntax error: line 1"）．
     * 入力ファイル内に複数のエラーが含まれる場合は，最初に見つけたエラーのみを出力すること．
     * 入力ファイルが見つからない場合は標準エラーに"File not found"と出力して終了すること．
     *
     * @param inputFileName 入力tsファイル名
     */
    public void run(final String inputFileName) {

        if (!inputFileName.endsWith(".ts")) {    //拡張子の識別
            System.err.println("Extension Error");
        }

        FileRead fileRead = new FileRead();
        fileRead.fileRead(inputFileName);

    }
}
