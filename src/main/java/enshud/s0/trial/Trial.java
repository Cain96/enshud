package enshud.s0.trial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Trial {
    /**
     * サンプルmainメソッド．
     * 単体テストの対象ではないので自由に改変しても良い．
     */
    public static void main(final String[] args) {
        // normalの確認
        new Trial().run("data/pas/normal01.pas");
        new Trial().run("data/pas/normal02.pas");
        new Trial().run("data/pas/normal03.pas");
    }

    /**
     * TODO
     * <p>
     * 開発対象となるTrial実行メソッド （練習用）．
     * 以下の仕様を満たすこと．
     * <p>
     * 仕様:
     * 第一引数で指定されたpascalファイルを読み込み，ファイル行数を標準出力に書き出す．
     * 入力ファイルが見つからない場合は標準エラーに"File not found"と出力して終了すること．
     *
     * @param inputFileName 入力pascalファイル名
     */
    public void run(final String inputFileName) {
        FileReader fr = null;
        BufferedReader br = null;
        int lineNumber = 0;
        try {
            fr = new FileReader(inputFileName);
            br = new BufferedReader(fr);
            while ((br.readLine()) != null) {
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("File not found");
        }

        System.out.println(lineNumber);

    }
}
