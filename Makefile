all:
	javac Kore.java KoreGame.java NoHandException.java NoPlayerException.java AlreadyOverException.java NotOverException.java NotEnoughException.java
	jar -cvf Kore.jar Kore.class KoreGame.class NoHandException.class NoPlayerException.class AlreadyOverException.class NotOverException.class NotEnoughException.class

clean:
	rm *.class Kore.jar

