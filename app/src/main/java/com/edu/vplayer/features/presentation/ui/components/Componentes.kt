package com.edu.vplayer.features.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.vplayer.R

@Composable
fun TextView(
    text: String,
    modifier: Modifier= Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
//    Text(
//        text = text,
//        modifier = modifier,
//        color = color,
//        fontFamily = fontFamily,
//        fontSize = fontSize,
//        fontWeight = fontWeight,
//    )
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        style = style
    )
}

// material button 3
@Composable
fun ButtonView(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    btnColor: ButtonColors,
    text: String,
    textStyle: TextStyle,
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = btnColor
    ) {
        TextView(text = text, style = textStyle, modifier = Modifier)
    }
}

// material button 3
@Composable
fun IconButtonView(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    btnColor: ButtonColors,
    text: String,
    textStyle: TextStyle,
    painter: Painter
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = btnColor
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            PainterImageView(
                painter = painter, modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
            TextView(text = text, style = textStyle, modifier = Modifier)
        }
    }
}

// text button
@Composable
fun TextButtonView(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle
) {
    TextButton(
        onClick = { onClick() },
        modifier = modifier,
    ) {
        TextView(text = text, style = textStyle, modifier = Modifier)
    }


}

@Composable
fun ClickableTextView(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(),
    softWrap: Boolean = false,
    overflow: TextOverflow.Companion = TextOverflow,
    maxLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: () -> Unit
) {
    ClickableText(text = text, onClick = { onClick() }, style = style)
}


// input text fields
@Composable
fun InputTextFieldView(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    leadingIcon: @Composable() (() -> Unit)? = null,
    modifier: Modifier ,
    placeholder: String,
    textStyle: TextStyle,
    isEmpty: Boolean = false,
    isError: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    shape: Shape = ShapeDefaults.Medium,
    invalidMessage: String,
    errorColor: Color = Color.Unspecified
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { TextView(text = label, style = textStyle) },
            placeholder = {
                TextView(
                    text = placeholder,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 24.sp
                    ),
                    modifier = Modifier
                )
            },
            trailingIcon = null,
            leadingIcon = leadingIcon,
            enabled = enabled,
            readOnly = readOnly,
            keyboardOptions = keyboardOptions,// KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = singleLine,
            maxLines = maxLines,
            shape = shape,
            isError = (isEmpty || isError),
            modifier = modifier
        )
        if (isEmpty) {
            TextView(text = "The field is empty!", style = TextStyle(color = errorColor))
        }
        if (isError) {
            TextView(text = invalidMessage, style = TextStyle(color = errorColor))
        }
    }
}

// password input text fields
@Composable
fun PasswordTextFieldView(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    leadingIcon: @Composable() (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    placeholder: String,
    textStyle: TextStyle,
    isEmpty: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    shape: Shape = ShapeDefaults.Medium,
    invalidMessage: String,
    errorColor: Color = Color.Unspecified
) {
    val passwordVisibility = remember { mutableStateOf(false) }
    var color by remember { mutableStateOf(Color.Transparent) }
    color = if (isEmpty) {
        errorColor
    } else {
        Color.Transparent
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { TextView(text = "", style = textStyle) },
        placeholder = {
            TextView(
                text = placeholder,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 24.sp
                ),
                modifier = Modifier
            )
        },
        enabled = enabled,
        shape = shape,
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        maxLines = maxLines,
        leadingIcon = leadingIcon,
        trailingIcon = {
            IconButton(
                onClick = { passwordVisibility.value = !passwordVisibility.value }
            ) {
                IconView(
                    imageVector = if (passwordVisibility.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                )
            }
        },
        isError = isEmpty,
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = modifier,
    )
    if (isEmpty) {
        TextView(text = invalidMessage, color = color)
    }
}

@Composable
fun PainterImageView(
    painter: Painter,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.None,
    alpha: Float = Float.MAX_VALUE,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter
    )
}

@Composable
fun IconView(
    imageVector: ImageVector,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}



@Composable
fun FullScreenLoaderComponent() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}


@Composable
fun SignInGoogleButton(
    onClick: () -> Unit,
) {
            Button(
                onClick = { onClick() },
                modifier = Modifier
                    .width(160.dp),
                colors = ButtonDefaults.buttonColors(Color.White),

                ) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_google),
                    contentDescription = null, modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                androidx.compose.material3.Text(text = "Google", color = Color.Black)
            }
        }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonAppBarView() {
    TopAppBar(
        title = { },
        navigationIcon = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .fillMaxHeight(),

                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_islington),
                    contentDescription = null,
                    Modifier
                        .padding(start = 10.dp)
                        .height(40.dp)
                        .width(40.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {

                    IconButton(
                        onClick = {
//                            navController.navigate(SearchBarItem.SearchBar.route)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    IconButton(
                        onClick = {
                            // onclick action
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    }

                }
            }
        },
        modifier = Modifier
            .shadow(5.dp)
    )
}

@Composable
fun SimpleButtonComponent(
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}


@Composable
fun InputFieldComponent(
    text: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    label: String = "Some val",
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = text,
        onValueChange = onChange,
        modifier = modifier,
        singleLine = singleLine,
        label = {
            Text(text = label)
        },
        keyboardActions = keyboardActions,
    )
}


