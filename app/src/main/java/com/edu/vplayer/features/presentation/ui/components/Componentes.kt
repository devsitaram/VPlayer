package com.edu.vplayer.features.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
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
import com.edu.vplayer.ui.theme.skyBlue

@Composable
fun TextView(
    text: String,
    modifier: Modifier = Modifier,
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
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
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
        minLines = minLines,
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
    textStyle: TextStyle
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = btnColor
    ) {
        TextView(text = text, style = textStyle, modifier = Modifier)
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

// input text fields
@Composable
fun InputTextFieldView(
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
fun ContentCardView(
    painter: Painter,
    topic: String,
    description: String,
    onClickable: () -> Unit = { }
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .border(1.dp, Color.LightGray)
            .clickable { onClickable() },
        shape = ShapeDefaults.Medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(start = 15.dp, end = 15.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.LightGray),
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    TextView(
                        text = topic, style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                        modifier = Modifier
                    )
                    TextView(
                        text = description,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 20.sp,
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.LightGray)
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Newspaper,
                        contentDescription = null,
                        tint = skyBlue,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    TextView(
                        text = "View Package Detail", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = skyBlue
                        ),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
    }
}