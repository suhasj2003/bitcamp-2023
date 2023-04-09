import React from 'react';
import { View, Text } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { Card } from './Components/Card.js';
import CardsSwipe from 'react-native-cards-swipe';
import { Image, StyleSheet} from 'react-native';


export default function App() {
  return (
    <View style={{flex: 1,
                  justifyContent: "center",
                  alignItems: "center",
                  backgroundColor: "#ffc2c2"}}>
      <Text>Hello World</Text>
      <Card />
      <StatusBar style="auto" />
    </View> 
  );
}


