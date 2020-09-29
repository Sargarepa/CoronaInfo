package com.example.coronainfo.network

import com.apollographql.apollo.ApolloClient

fun provideApolloClient(): ApolloClient = ApolloClient.builder()
    .serverUrl("https://api-corona.azurewebsites.net/graphql")
    .build()