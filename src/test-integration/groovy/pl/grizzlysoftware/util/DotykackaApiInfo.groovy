/*
 * Copyright 2019 Grizzly Software, https://grizzlysoftware.pl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY 
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN 
 * THE SOFTWARE.
 */

package pl.grizzlysoftware.util

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
interface DotykackaApiInfo {
    String API_URL = System.getenv("API_URL")
    String CLOUD_ID = System.getenv("CLOUD_ID")
    Long WAREHOUSE_ID = Long.valueOf(System.getenv("WAREHOUSE_ID"))
    String API_TOKEN_USERNAME = System.getenv("API_TOKEN_USERNAME")
    String API_TOKEN_PASSWORD = System.getenv("API_TOKEN_PASSWORD")
    String ACCESS_TOKEN_API_TOKEN = System.getenv("ACCESS_TOKEN_API_TOKEN")
    String ACCESS_TOKEN_USERNAME = System.getenv("ACCESS_TOKEN_USERNAME")
    String ACCESS_TOKEN_PASSWORD = System.getenv("ACCESS_TOKEN_PASSWORD")
}
