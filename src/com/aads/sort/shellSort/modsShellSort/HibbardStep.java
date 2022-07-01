package com.aads.sort.shellSort.modsShellSort;

class HibbardStep implements StepGenerator {
    private int i;

    public HibbardStep(int[] array) {
        for (; (int) (Math.pow(2, i) - 1) < array.length;) {
            i += 1;
        }
    }

    @Override
    public int nextStep() {
        i = i - 1;
        return (int) (Math.pow(2, i) - 1);
    }

}
