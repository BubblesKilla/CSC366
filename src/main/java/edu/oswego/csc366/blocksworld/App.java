package edu.oswego.csc366.blocksworld;

import java.util.List;
import java.util.Deque;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    static final int STACK_COUNT = 4;
    static final int BLOCK_COUNT = 6;
    static List<Deque<Character>> stacks;

    public static void main( String[] args ) {
        var blocks = generateBlocks();
        var stacks = initialConfig(blocks);
    }

    private static List<Character> generateBlocks() {
        var blocks = new ArrayList<Character>();
        char current = 'A';
        for(int i = 0; i < BLOCK_COUNT; i++)
            blocks.add(current++);
        return blocks;
    }

    private static ArrayList<ArrayDeque<Character>> initialConfig(List<Character> blocks) {
        var stacks = new ArrayList<ArrayDeque<Character>>();

        for(int i = 0; i < STACK_COUNT; i++)
            stacks.add(new ArrayDeque<>());

        while(blocks.size() > 1)
            stacks.get(ThreadLocalRandom.current().nextInt(stacks.size()))
                    .add(blocks.remove(ThreadLocalRandom.current().nextInt(blocks.size())));
        stacks.get(ThreadLocalRandom.current().nextInt(stacks.size()))
                .add(blocks.get(0));

        return stacks;
    }
}
