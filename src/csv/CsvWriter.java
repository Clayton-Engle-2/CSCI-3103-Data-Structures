package csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.containers.Analysis;

public class CsvWriter implements Runnable {
    private final Pipe<Analysis> analysisPipe;
    private final Pipe<Instruction> instructionPipe;
    private final File file;
    private final BufferedWriter writer;

    public CsvWriter(Pipe<Analysis> analysisPipe, Pipe<Instruction> instructionPipe, String filename) throws IOException {
        this.analysisPipe = analysisPipe;
        this.instructionPipe = instructionPipe;
        this.file = new File(filename);
        this.writer = new BufferedWriter(new FileWriter(file));
    }

    @Override
    public void run() {
        while (true) {
            if (instructionPipe.hasInput()) {
                Instruction instruction = instructionPipe.take();
                if (instruction == Instruction.CLOSE) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (analysisPipe.hasInput()) {
                Analysis analysis = analysisPipe.take();
                try {
                    writer.write(analysis.toString());
                    writer.newLine();
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
