import React from 'react';
import { Image, StyleSheet, View } from 'react-native';
import CardsSwipe from 'react-native-cards-swipe';

const cardsData = [
  { src: require('../assets/adaptive-icon.png') },
  { src: require('../assets/favicon.png') },
  { src: require('../assets/icon.png') },
  { src: require('../assets/splash.png') },
];

export function Card() {
  return (
    <View style={styles.container}>
      <CardsSwipe
        cards={cardsData}
        cardContainerStyle={styles.cardContainer}
        renderCard={(card) => (
          <View style={styles.card}>
            <Image
              style={styles.cardImg}
              source={card.src}
            />
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  cardContainer: {
    width: '92%',
    height: '70%',
  },
  card: {
    width: '100%',
    height: '100%',
    shadowColor: '#000000',
    shadowOffset: {
      width: 0,
      height: 8,
    },
    shadowOpacity: 0.07,
    shadowRadius: 3.3,
  },
  cardImg: {
    width: '100%',
    height: '100%',
    borderRadius: 13,
  },
  
});