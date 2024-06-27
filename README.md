# Reciipiie

Reciipiie is a user-friendly recipe app that allows users to explore popular indian food recipes. Users can also add recipes to their favorites list and view them later.

## Features

- Sign in with Google
- Search for recipes by name
- View the recipe details
- Add recipes to favorites list

## Tech Stack

- Kotlin
- Firebase
- Android Studio

<p align="center">
    <a href="https://www.divyanshgemini.dev/">
        <img src="https://skillicons.dev/icons?i=androidstudio,kotlin,firebase" alt="tech stack" />
    </a>
</p>

## Screenshots

<p align="center">
    <img src="https://github.com/Divyansh-Gemini/Reciipiie/assets/88696617/295b7c43-abfb-4ef5-a37f-259397ecb227" height="400" alt=""/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="https://github.com/Divyansh-Gemini/Reciipiie/assets/88696617/fcd2d02c-3e29-4b99-9fed-745012e11b5c" height="400" alt=""/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="https://github.com/Divyansh-Gemini/Reciipiie/assets/88696617/039307a8-1ab0-43a4-a437-260fce4fcce5" height="400" alt=""/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="https://github.com/Divyansh-Gemini/Reciipiie/assets/88696617/9b9c2198-74f7-48ad-abef-9dece926e026" height="400" alt=""/>
</p>

## Installation Steps

1. Clone the repository.
   ```bash
   git clone https://github.com/Divyansh-Gemini/Reciipiie.git
   ```
2. Open the project in Android Studio.
3. Connect project with Firebase.
4. Make sure `google-services.json` is present in the `app` directory.
5. Signup at [spoonacular.com](https://spoonacular.com/food-api/console#Dashboard).
6. Copy & save API Key from [profile page](https://spoonacular.com/food-api/console#Profile).
7. To keep the API Key secure, store it in `local.properties` file in the project. Also put your Firebase OAuth Web Client ID in the same file (you can find it on Fierbase Console or in `google-services.json`).

   ```
   ...
   SPOONACULAR_API_KEY = YOUR_API_KEY
   OAUTH_WEB_CLIENT_ID = YOUR_FIREBASE_OAUTH_WEB_CLIENT_ID

   ```

8. Run the application.
