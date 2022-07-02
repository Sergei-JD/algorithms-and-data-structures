package com.aads.sort.shellSort.modsShellSort;

class KnuthStep implements StepGenerator {
    private int i;

    public KnuthStep(int[] array) {
        while ((Math.pow(3, i) - 1) / 2 < array.length / 3) {
            i = i + 1;
        }
    }

    @Override
    public int nextStep() {
        int step = (int) ((Math.pow(3, i) - 1) / 2);
        i = i - 1;
        return step;
    }

}
