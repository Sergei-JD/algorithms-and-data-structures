package com.aads.sort.shellSort.modsShellSort;

class ShellStep implements StepGenerator {
    private int step;

    public ShellStep(int[] array) {
        step = array.length / 2;
    }

    @Override
    public int nextStep() {
        step = step / 2;
        return step;
    }

}
