package gitsAndShiggels;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PhilosiphyProject extends Application {

	Stage myStage;
	Button btnBack = new Button("Back");
	Scene scene;
	String[] abc = {
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "Reflection"
	};
	String[] titls = {
			"Atom", "Big Bang", "Cause and Effect", "Dark Matter", "Energy", "Friction", "Great Filters", "Heisenberg Uncertainty Principle", 
			"Infinity’s size", "Joule", "Kinematics", "Laplace’s Angel", "Matter", "Neutrino", "Ohm", "P-Branes", 
			"Quantum Entangelment", "Radiation", "String Theory", "Time", "Universe", "mulitVerse", "Waves", 
			"X-rays", "Youngs Model", "Zero Point", "What I have learned about reality"
	};
	String[] bodies = {
			"Atoms  are a fundamental part of the universe. These unseen bundles of energy make up all matter in our universe. Atoms are made of protons, neutrons, and electrons, the combination of which determine the type and behavior of an atom.\n atoms can be manipulated and changed into other atoms through varying methods. atoms are significant because of how they make up 100% of the observable universe.",
			"The Big Bang is the most popular theory addressing the creation of the universe. It states that before what we know the universe as now, there was a relatively small ball of complete energy that one day exploded and expanded into what\n we now know as the universe. At that moment was when all the matter and energy in the universe was created. this is relevant as it provides a definition for how the universe came into being",
			"Cause and Effect says everything that happens leads to something else happening in a predictable way. one atom hits another and that one hits another and so on until you end up making a decision that was caused by the first atom hitting\n the second. This is significant because of the reliance theories, formulas, and many other aspects of physics has on something being caused by something else.",
			"Dark Matter has come to our attention not because we have seen or interacted with it, but because of the process of elimination. Basically we have no idea what is in the dark space in the universe keeping galaxies together. To solve this\n gap in logic we came up with dark matter as a solution. The current state of the elimination is that it is not normal matter, it is not antimatter, and it is not any sort of black hole related object. This is relevant because it makes up \na large part of our universe but is somehow completely un observable, making us question if it is real or made up.",
			"Energy is a sort of currency transferred around the universe to pay for actions things take. Just like matter, it was scattered at the big bang and cannot be created or destroyed, only changed. Whenever we burn things to make electricity\n we are just taking potential energy and changing it into electricity. then that electricals get turned back into heat and light, then the light back to heat and the cycle continues. This is significant because like with society, nothing \ncan happen without currency.",
			"Friction is basically an object's resistance to moving in relation to another object. object is used lightly here as air is considered an object. friction has no reliance on mass and is only influenced by the material of the objects used.\n This is relevant as since the term object is so vague it may end up including dark matter and other like things, creating an invisible force we did not know about.",
			"Great Filters are a concept that prevents intelligent life from reaching the next big step in evolution. In order for life to exist it needs to overcome hundreds, maybe thousands of these great filters like oxygen, temperature, and life to\n actually spark. Our planet has survived a couple famous filters such as the ice age, the dinosaur extinction, and many didesses. This is relevant to put into perspective the rarity we as a living planet are and make us think more about \nour existence.",
			"Heisenberg Uncertainty Principle states that we cannot know the location and trajectory of any particle. This is because inorder to see something we need to have some sort of energy bounce off of it, in doing so we change the momentum and\n position of the particle being observed. There are ways to see where it is and to get its momentum, but trying to do both is like trying to feel something in your teeth and get it out at the same time, it just does not work. This is \nrelevant because it reminds us of our limitations and challenges us to get through.", 
			"infinity is big, there are more real numbers than you could write out. but that is not how big infinity really is. think about this, for each number, say between 0 - 1, there are an infinite amount of unique decimals, easily shown like this\n 0.1, 0.11, 0.111, 0.1111… these repeating ones go on forever making it the same size as the infinity of real numbers, but that means there are an infinite amount of infinities in infinity. So the answer to how big is infinity is really \nyes because within infinity lies more infinities. This is relevant as it proves to us that there is truly never a lack of something in our world, there is always something someone has never seen or done.",
			"A Joule is a unit of measure that measures the amount of energy. What a joule is essentially is the name of the currency of the universe. Say you want to buy a star, our sun makes 3.8 x 10²⁶ joules of energy every second, meaning that if you\n were to buy one from our universe, you would have to pay  3.8 x 10²⁶ joules of energy every second. This is relevant because of the idea that everything in our universe has a cost, including things like good and bad days.",
			"Kinematics is how something moves without knowing why. Basically it is a reference to studying how something might be falling without looking at gravity and all the properties that the object might have as a result. This is relevant as it is\n another way we study the laws of nature we are living in, granting us a higher understanding of the universe.",
			"Laplace’s Angel is a theory that if there were such a being that knew the exact position over every atom and its momentum, and had the ability to calculate the universe, it would be able to know everything that has and will happen. This is\n based on the idea of cause and effect being predictable. When the computer was first invented some people thought the angel may become a reality, but modern science states that there is no possible way for something like that to exist \ndue to the Heisenberg Uncertainty Principle. This is relevant because though it is not yet possible it provides a solid theoretical example of a time machine.",
			"Matter is what is otherwise known as solid material. matter is composed of atoms and cannot be created or destroyed. If you break a plate, the matter from the plate simply scatters but does not and will never disappear. matter has varying\n properties, the most notable of which is the state of the matter. the state of matter changes with the temperature or how much energy the atoms have stored inside. This is relevant because it shows the universe is made of things and \ncan never be destroyed, only changed. ",
			"A Neutrino is a particle way too small for almost anything to detect. A neutrinos' size is manu times smaller than an atom, meaning it can easily glide through almost anything. They are created through violent reactions such as potassium \ndecaying, nuclear reactors, and particle accelerators. The only way we have found to detect them is to hope that one collides with an atom, realing blue light the same way a plane would produce a sonic boom and capture the light from \nthat interaction. This is relevant because it allows you to understand that some of the things we know about our universe really only came to our attention by chance, so it helps us question things we perceive as fact",
			"An Ohm is a unit of measure regarding the resistance of a material to electrical current. Ohms don't really measure anything tangible, they only measure a lack of something or the property of something. this is relevant as it shows there \nis way more that one way to measure our world.",
			"P-Branes are a part of string theory that is not a string. string theory supports the idea of a higher dimensional string with the same properties of a string in string theory, these high dimensional strings are called p-branes, and come \nfrom the word membrane. a brane can be up to 9 dimensions as each of them vibrate at a dimension 2 higher than themself and 11 is the last stable dimension. This is an important idea because it tells us what the universe beyond our \nunderstanding contains and gives us a larger scope of thinking.", 
			"Quantum Entangelment is a state two objects can be in where they do something opposite of each other no matter the outcome. For example if two particles are entangled to spin in opposite directions, no matter where they are in the universe, \nchanging the direction of one's spin will change the direction of the other's spin. This is relevant because of the implications of the tech in our modern day lives.",
			"Radiation is basically unstable atoms becoming stable. They do this by shooting off the parts that make them unstable, and those atoms shooting off with a lot of force causes what we know commonly as radiation. This is relevant because the \nidea behind atoms always wanting to be stable shows us the universe has a particular order it was not to be in and that must mean anything that happens to us is to please that order.",
			"String Theory is a theory that states the smallest thing in our world is a one dimensional string that vibrates so fast it creates 3 dimensional objects. The key is to have the string vibrate at or faster than the speed of light. Though it \nwas first only thought of with the string that makes up our 3 dimensional space, it was discovered that the same theory can be applied to height dimensions. The rule of thumbs is when an object vibrates fast enough it makes an object \n2 dimensions higher than itself. This means if you vibrated a 2 dimensional object fast enough it would become a time object. This is relevant as it connects multidimensional planes with higher and lower ones providing people a more \nconnected view on reality.",
			"Time Time is a unit of measure that is used to keep track of the state of the universe as many operations go on throughout it. The scope of these operations can be as small as looking at what happens to an atom over time or how the universe \nexpands in real time. This is relevant as time is one of if not the most common unit of measure and without if most everything in physics would be riddled with holes.",
			"Universe The universe, put simply, is everything within the human line of sight. anything we have seen makes up our universe. This does not mean that there is nothing past our line of sight, our universe is constantly expanding as more and \nmore light reaches our planet. The idea of another or alternate universe is that there are things in our current universe that exist nowhere in the other one or vice versa. This is relevant as it provides a sense of the true expanse \nof what we know.",
			"mulitVerse is the idea that there are many other universes out there. Though there are many, the most popular multiversal theory is the many worlds theory. This theory states that for every division we make there is another universe where \nwe do make that decision. This is relevant as it allows us to have peace of mind knowing that even if we make the wrong choice, one of us made the right one.",
			"Waves is a disturbance that travels from place to place. basically one atom hits another, that hits another and so on. This constant transference of force is called a wave. waves are used for many things but the most common application is \nfor us to observe our universe. On a day to day basis we see light waves and this allows us to see physical things in our world, but we also send waves into space to see what is happening there. This is relevant as waves are the main \nway we perceive our universe and without them we would literally be in the dark about a lot of things.",
			"X-rays are a type of waves that vibrates at a high enough frequency to pass through some less dense masses. This is mainly used in medical fields to look past people's flesh and see their bones for the purpose of understanding breaks and \nfractures. This is relevant as it allows us to understand the inner workings of ourselves without having to destroy our own bodies.",
			"Youngs Model is a ratio describing how easily a physical object can be stretched or deformed. It is defined as a ratio between stress and strain. It is mainly used to tell how much room has to be left when planning for creation that is \nunder lots of stress. This is relevant as it shows us that we can understand the world in new ways only by combining the things we already do. ",
			"Zero Point is the point in space or on a graph that represents the crossing of the axis or the point where positive becomes negative. on a graph this is the point where all functions originate before having translations and reflection \napplied. This is relevant because understanding the zero point in higher dimensions like time might show us where positive and negative matter come from. ",
			"Learning is a process abundant in our day to day lives, for me learning is happening whether i like it or not. During this project I have kept track of what I have learnt and thought it was quite interesting. First off, I have learnt \nthat I don't like keeping track of my learning, this seems odd to me as normally I enjoy exploring my own consciousness. however this form of understanding how i understand things was a little too much for my brain to be comfortable with.\n Secondly, I learnt that small can be VERY small. Before this unit I was blissfully unaware just how small we understand about our world. string theory and the idea of vibrating objects to create higher planes make me wonder about what a \n0 dimensional object might be, just a point maybe? Lastly, I learnt about just how vast our universe is. I didn't realize that there was more than one dimension above us, time I can visualize but things higher than that make my head spin. \nThe sheer scale of our universe is so huge that this idea of there being more than one, even an infinite number, or how there are infinite infinities simply makes me question whether my definitions of bug and small really exist. \nlong story short, I found this project very enlightening even if I did not enjoy reflection in it as much."
	};
	
	public void back () {
		myStage.setScene(scene);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		myStage = primaryStage;
		
		
		Button[] btnArray = {
				new Button(),
				new Button(),
				new Button(), 
				new Button(),
				new Button(),
				new Button(), 
				new Button(), 
				new Button(), 
				new Button(), 
				new Button(), 
				new Button(), 
				new Button(),
				new Button(),
				new Button(),
				new Button(), 
				new Button(),
				new Button(),
				new Button(), 
				new Button(), 
				new Button(), 
				new Button(), 
				new Button(), 
				new Button(), 
				new Button(),
				new Button(), 
				new Button(), 
				new Button()};
		for (int i = 0; i < abc.length; i++) {
			btnArray[i] = makeButton(abc[i], i);
		}
		
		Menu menu = new Menu(btnArray, myStage.getScene(), 0, 100, false);
		scene = new Scene(menu);
		
		myStage.setScene(scene);
		myStage.show();
		}

	public Button makeButton(String name, int btnNumber) {
		Button btn = new Button(name);
		btn.setFont(Font.font(12));
		btn.setOnAction(event -> openBtn(titls[btnNumber], bodies[btnNumber]));
		return btn;
	}
	
	public void openBtn (String title, String body) {
		btnBack.setOnAction(event -> back());
		GridPane root = new GridPane();
		Label lblTit = new Label(title);
		Label lblBdy = new Label(body);
		lblTit.setFont(Font.font(24));
		lblBdy.setFont(Font.font(12));
		root.add(lblTit, 0, 0);
		root.add(lblBdy, 0, 1);
		root.add(btnBack, 0, 2);
		
		Scene scene = new Scene(root);
		myStage.setScene(scene);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
