package hu.nye.progtech.battleship.model;

import java.util.Objects;

/**
 * Count statistic for players game.
 */
public abstract class Statistics {
    private int numberOfHits;
    private int numberOfSteps;
    private int numberOfGames;
    private int numberOfWins;

    public Statistics(int numberOfHits, int numberOfSteps, int numberOfGames, int numberOfWins) {
        this.numberOfHits = numberOfHits;
        this.numberOfSteps = numberOfSteps;
        this.numberOfGames = numberOfGames;
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    public void setNumberOfHits(int numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statistics that = (Statistics) o;
        return numberOfHits == that.numberOfHits && numberOfSteps == that.numberOfSteps &&
                numberOfGames == that.numberOfGames && numberOfWins == that.numberOfWins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfHits, numberOfSteps, numberOfGames, numberOfWins);
    }
}
