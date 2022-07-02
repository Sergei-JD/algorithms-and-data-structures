package com.aads.sort.shellSort.modsShellSort;

class SedgewickStep implements StepGenerator {
    private int i;

    public SedgewickStep(int[] array) {
        long number = (long) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
        while (number < array.length) {
            i += 1;
            if (i % 2 == 0) {
                number = (long) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
            } else {
                number = (long) (8 * Math.pow(2, i) - 6 * Math.pow(2, (i + 1) / 2) + 1);
            }
        }
    }

    @Override
    public int nextStep() {
        i = i - 1;
        if (i <= -1) {
            return 0;
        }
        if (i % 2 == 0) {
            return (int) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
        } else {
            return (int) (8 * Math.pow(2, i) - 6 * Math.pow(2, (i + 1) / 2) + 1);
        }
    }

}
